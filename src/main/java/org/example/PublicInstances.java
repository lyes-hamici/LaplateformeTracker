package org.example;

import org.example.model.*;

public class PublicInstances {
    public static Db db = new Db();
    public static UserRepo userRepo = new UserRepo(db);
    public static GradesRepo gradesRepo = new GradesRepo(db);
    public static StudentRepo studentRepo = new StudentRepo(db);
    public static FileManager fileManager = new FileManager(db);
}
