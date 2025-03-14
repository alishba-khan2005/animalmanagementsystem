

package com.mycompany.animalmanagement;

import java.util.ArrayList;
import java.util.Scanner;

// Base class: Animal
class Animal {
    private String name; // Name of the animal
    private String type; // Type of the animal (e.g., Dog, Cat)

    // Constructor to initialize name and type
    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getters for name and type
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    // Method to make a sound (can be overridden)
    public void makeSound() {
        System.out.println(name + " the " + type + " makes a sound.");
    }
}

// Subclass: Dog
class Dog extends Animal {
    public Dog(String name) {
        super(name, "Dog");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Dog says: Woof Woof!");
    }
}

// Subclass: Cat
class Cat extends Animal {
    public Cat(String name) {
        super(name, "Cat");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Cat says: Meow!");
    }
}

// Main class for the Management System
public class Animalmanagement {
    private static ArrayList<Animal> animalList = new ArrayList<>(); // List to store animals

    // Method to add a new animal
    public static void addAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal (Dog/Cat): ");
        String type = scanner.nextLine().trim();
        System.out.println("Enter the name of the animal: ");
        String name = scanner.nextLine().trim();

        if (type.equalsIgnoreCase("Dog")) {
            animalList.add(new Dog(name));
        } else if (type.equalsIgnoreCase("Cat")) {
            animalList.add(new Cat(name));
        } else {
            System.out.println("Unknown animal type. Try again.");
        }
    }

    // Method to list all animals
    public static void listAnimals() {
        if (animalList.isEmpty()) {
            System.out.println("No animals in the system.");
        } else {
            System.out.println("Animals in the system:");
            for (int i = 0; i < animalList.size(); i++) {
                Animal animal = animalList.get(i);
                System.out.println((i + 1) + ". " + animal.getType() + " - " + animal.getName());
            }
        }
    }

    // Method to make an animal sound
    public static void makeAnimalSound(Scanner scanner) {
        if (animalList.isEmpty()) {
            System.out.println("No animals available to make a sound.");
            return;
        }

        System.out.println("Enter the number of the animal to make it sound: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (number > 0 && number <= animalList.size()) {
            animalList.get(number - 1).makeSound();
        } else {
            System.out.println("Invalid animal number. Try again.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAnimal Management System");
            System.out.println("1. Add Animal");
            System.out.println("2. List Animals");
            System.out.println("3. Make Animal Sound");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    listAnimals();
                    break;
                case 3:
                    makeAnimalSound(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
