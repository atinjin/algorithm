package com.github.atinjin.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CatAndDogQueue {

    public static void main(String[] args) {

        CatAndDogQueue q = new CatAndDogQueue();
        q.enqueue(new Dog("1"));
        q.enqueue(new Dog("2"));
        q.enqueue(new Cat("3"));
        q.enqueue(new Dog("4"));

        Cat cat = q.dequeueCat();
        System.out.println(cat.getName());
    }

    public Queue<Animal> queue = new LinkedList<>();

    public void enqueue(Animal a) {
        queue.offer(a);
    }

    public static class Animal {
        String name;

        public Animal(String name) {this.name = name;}
        public String getName() {
            return this.name;
        }
    }

    public Cat dequeueCat() {
        Stack<Animal> stack = new Stack<>();
        while(queue.peek() != null && !(queue.peek() instanceof Cat) ) {
            Animal dog = queue.poll();
            stack.push(dog);
        }
        Cat result = null;
        if(queue.peek() != null)
            result = (Cat)queue.poll();

        if(stack.size() > 0)
            while(!stack.empty())
                queue.offer(stack.pop());

        return result;
    }


    public Cat dequeueDog() {

        return null;
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }

    public static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }

}