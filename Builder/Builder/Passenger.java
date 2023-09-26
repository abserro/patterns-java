package Builder;

public abstract class Passenger {
    private String name;
    private int age;
    private CategoryPassenger categoryPassenger;

    public Passenger(String name, int age, boolean benefit) {
        this.name = name;
        this.age = age;
        if (benefit) {
            this.categoryPassenger = CategoryPassenger.Benefit;
        } else {
            this.categoryPassenger = (this.age < 7) ? CategoryPassenger.Child : CategoryPassenger.Adult;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCategoryPassenger(CategoryPassenger categoryPassenger) {
        this.categoryPassenger = categoryPassenger;
    }

    public CategoryPassenger getCategoryPassenger() {
        return this.categoryPassenger;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void viewInfo() {
        System.out.println("\tName: " + this.name);
        System.out.println("\tAge: " + this.age);
        System.out.println("\tCategory: " + this.categoryPassenger);
    }
}
