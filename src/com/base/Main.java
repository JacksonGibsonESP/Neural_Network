package com.base;

public class Main {

    public static void main(String[] args) {
        Brain brain = new Brain();

        brain.addRowToTrainingSet(new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{1, 0, 0, 1});
        brain.addRowToTrainingSet(new double[]{0, 1, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0, 1, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 1, 0, 0, 0, 0, 0, 0}, new double[]{0, 1, 1, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 1, 0, 0, 0, 0, 0}, new double[]{1, 0, 0, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, new double[]{0, 0, 0, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 0, 0, 1, 0, 0, 0}, new double[]{0, 0, 1, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 0, 0, 0, 1, 0, 0}, new double[]{1, 1, 0, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 0, 0, 0, 0, 1, 0}, new double[]{0, 1, 0, 0});
        brain.addRowToTrainingSet(new double[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, new double[]{0, 1, 1, 0});

        brain.learn();
        brain.saveNNToFile("neural_network");
        brain.setInput(new double[]{1, 1, 0, 1, 0, 0, 0, 0, 0});
        brain.think();
        double[] brainOutput = brain.getOutput();
        for(int i = 0; i < brainOutput.length; i++){
            System.out.println(brainOutput[i]);
        }
    }
}
