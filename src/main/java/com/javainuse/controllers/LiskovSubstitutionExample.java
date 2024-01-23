package com.javainuse.controllers;

public class LiskovSubstitutionExample {
	
	 public static void main(String[] args) {
	        Bird sparrow = new Sparrow();
	        Bird penguin = new Penguin();

	        // Both Sparrow and Penguin can be used wherever a Bird is expected.
	        sparrow.fly();  // Outputs: The bird is flying.
	        penguin.fly();  // Outputs: Penguins can't fly.
	    }

}

class Bird {
    void fly() {
        System.out.println("The bird is flying.");
    }
}

class Sparrow extends Bird {
	    @Override
	    void fly() {
	        System.out.println("Penguins can't fly.");
	    }
	
    // The Sparrow class inherits the fly() method from the Bird class.
}

class Penguin extends Bird {
    // Penguins can't fly, so we override the fly() method to provide a different behavior.
    @Override
    void fly() {
        System.out.println("Penguins can't fly.");
    }
}
