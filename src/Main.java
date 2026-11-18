
public class Main {

    // ================= LEARNER CLASS =================
    static class Learner {

        private final int id;
        private String name;
        private int age;

        private static int nextId = 1;

        // Default constructor
        public Learner() {
            this.id = nextId++;
            this.name = "Unknown";
            this.age = 0;
        }

        // Parameterized constructor
        public Learner(String name, int age) {
            this.id = nextId++;
            this.name = name;
            this.age = age;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            if (age >= 0) {
                this.age = age;
            }
        }

        // Method
        public void displayInfo() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }

        // Method overloading
        public void displayInfo(boolean showId) {

            if (showId) {
                System.out.println("ID: " + id);
            }

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    // ================= INSTRUCTOR CLASS =================
    static class Instructor {

        private final int id;
        private String name;
        private String specialization;

        private static int nextId = 1;

        public Instructor() {
            this.id = nextId++;
            this.name = "Unknown";
            this.specialization = "Not specified";
        }

        public Instructor(String name, String specialization) {
            this.id = nextId++;
            this.name = name;
            this.specialization = specialization;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSpecialization(String specialization) {
            this.specialization = specialization;
        }

        public void displayInfo() {
            System.out.println("Instructor ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialization: " + specialization);
        }
    }

    // ================= TRAINING CLASS =================
    static class Training {

        private String title;
        private Instructor instructor;

        private Learner[] learners;
        private int learnerCount;

        private static int trainingCount = 0;

        // Constructor 1
        public Training(String title) {
            this(title, 5);
        }

        // Constructor 2
        public Training(String title, int capacity) {
            this.title = title;
            this.learners = new Learner[capacity];
            this.learnerCount = 0;
            this.instructor = null;

            trainingCount++;
        }

        public void setInstructor(Instructor instructor) {
            this.instructor = instructor;
        }

        public void addLearner(Learner learner) {

            if (learner == null) {
                System.out.println("Invalid learner!");
                return;
            }

            if (learnerCount < learners.length) {
                learners[learnerCount] = learner;
                learnerCount++;

                System.out.println("Learner added successfully!");
            } else {
                System.out.println("Training is full!");
            }
        }

        public void displayTraining() {

            System.out.println("\n===== TRAINING INFORMATION =====");
            System.out.println("Title: " + title);

            System.out.println("\nInstructor:");

            if (instructor != null) {
                instructor.displayInfo();
            } else {
                System.out.println("No instructor assigned.");
            }

            System.out.println("\nLearners:");

            for (int i = 0; i < learnerCount; i++) {
                System.out.println("\nLearner " + (i + 1));
                learners[i].displayInfo();
            }

            System.out.println("\nTotal learners: " + learnerCount);
        }

        public static void displayCount() {
            System.out.println("Total trainings: " + trainingCount);
        }
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        // Creating Learners
        Learner l1 = new Learner("Ahmed", 20);
        Learner l2 = new Learner("Yacine", 21);
        Learner l3 = new Learner();

        // Using setters
        l3.setName("Mohamed");
        l3.setAge(19);

        // Creating Instructor
        Instructor instructor =
                new Instructor("Mr. Karim", "Java Programming");

        // Creating Trainings
        Training t1 = new Training("Java OOP", 3);
        Training t2 = new Training("Python", 5);

        // Assigning instructor
        t1.setInstructor(instructor);

        // Adding learners
        t1.addLearner(l1);
        t1.addLearner(l2);
        t1.addLearner(l3);

        // Displaying training
        t1.displayTraining();

        // Method overloading
        System.out.println("\n===== METHOD OVERLOADING =====");

        l1.displayInfo();

        System.out.println("----------------");

        l1.displayInfo(true);

        // Static method
        System.out.println("\n===== STATIC =====");
        Training.displayCount();

        // Null example
        Learner l4 = null;

        if (l4 == null) {
            System.out.println("\nl4 does not reference an object.");
        }
    }
}
