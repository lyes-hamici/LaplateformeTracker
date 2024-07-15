import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRepo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mon_ecole";
        String username = "root";
        String password = "root";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);
           
            Scanner scanner = new Scanner(System.in);

            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Modifier un utilisateur");
            System.out.println("3. Supprimer un utilisateur");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    // Ajouter un utilisateur
                    System.out.print("ID : ");
                    String id = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nom : ");
                    String lastName = scanner.nextLine();
                    System.out.print("Âge : ");
                    int age = scanner.nextInt();
                    System.out.print("Grade : ");
                    String grade = scanner.nextLine();

                    String insertSql = "INSERT INTO student (id, first_name, last_name, age, grade) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                    insertStatement.setString(1, id);
                    insertStatement.setString(2, firstName);
                    insertStatement.setString(3, lastName);
                    insertStatement.setInt(4, age);
                    insertStatement.setString(5, grade);
                    int rowsInserted = insertStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Un nouvel étudiant a été inséré avec succès !");
                    }
                    break;

                case 2:
                    // Modifier un utilisateur
                    System.out.print("Entrer l'ID de l'utilisateur à modifier : ");
                    String idToUpdate = scanner.nextLine();

                    String selectSql = "SELECT * FROM student WHERE id=?";
                    PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                    selectStatement.setString(1, idToUpdate);
                    ResultSet resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {

                        System.out.print("Nouveau nom : ");
                        String newLastName = scanner.nextLine();
                        System.out.print("Nouveau prénom : ");
                        String newFirstName = scanner.nextLine();
                        System.out.print("Nouvel âge : ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nouveau grade : ");
                        String newGrade = scanner.nextLine();

                        String updateSql = "UPDATE student SET last_name=?, first_name=?, age=?, grade=? WHERE id=?";
                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                        updateStatement.setString(1, newLastName);
                        updateStatement.setString(2, newFirstName);
                        updateStatement.setInt(3, newAge);
                        updateStatement.setString(4, newGrade);
                        updateStatement.setString(5, idToUpdate);

                        int rowsUpdated = updateStatement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("L'utilisateur a été mis à jour avec succès !");
                        }
                    } else {
                        System.out.println("Aucun utilisateur trouvé avec cette ID.");
                    }
                    break;

                case 3:
                    // Supprimer un utilisateur
                    System.out.print("ID de l'utilisateur à supprimer : ");
                    int idToDelete = scanner.nextInt();

                    String deleteSql = "DELETE FROM student WHERE id=?";
                    PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                    deleteStatement.setInt(1, idToDelete);
                    int rowsDeleted = deleteStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("L'utilisateur a été supprimé avec succès !");
                    } else {
                        System.out.println("Aucun utilisateur trouvé avec cet ID.");
                    }
                    break;

                default:
                    System.out.println("Choix invalide !");
                    break;
            }


            conn.close();
            scanner.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Le pilote JDBC n'a pas été trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
        }
    }
}
