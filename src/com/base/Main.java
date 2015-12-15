package com.base;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.transfer.Linear;
import org.neuroph.core.transfer.Sigmoid;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.comp.layer.InputLayer;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.NeuralNetworkType;
import org.neuroph.util.NeuronProperties;
import org.neuroph.util.TransferFunctionType;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Integer> neuronsInLayers = new ArrayList<>();
        neuronsInLayers.add(9);
        neuronsInLayers.add(9);
        neuronsInLayers.add(9);
        neuronsInLayers.add(4);
        NeuralNetwork neuralNetwork = new MultiLayerPerceptron(neuronsInLayers, new NeuronProperties(TransferFunctionType.SIGMOID, true));

        neuralNetwork.setLearningRule(new BackPropagation());

        Neuron[] OutputLayerNeurons = neuralNetwork.getOutputNeurons();
        for(int i = 0; i < OutputLayerNeurons.length; i++) {
            OutputLayerNeurons[i].setTransferFunction(new Linear());
        }

        /*Neuron[] InputLayerNeurons= new Neuron[9];

        for(int i = 0; i < InputLayerNeurons.length; i++)
            InputLayerNeurons[i].setTransferFunction(new Sigmoid());*/
        /*
        Layer InputLayer        = new InputLayer(10);
        Layer FirstHiddenLayer  = new Layer(10, new NeuronProperties(TransferFunctionType.SIGMOID, false));
        Layer SecondHiddenLayer = new Layer(10, new NeuronProperties(TransferFunctionType.SIGMOID, false));
        Layer OutputLayer       = new Layer(4,  new NeuronProperties(TransferFunctionType.LINEAR,  false));

        NeuralNetwork neuralNetwork = new NeuralNetwork();

        neuralNetwork.addLayer(0, InputLayer);
        neuralNetwork.addLayer(1, FirstHiddenLayer);
        neuralNetwork.addLayer(2, SecondHiddenLayer);
        neuralNetwork.addLayer(3, OutputLayer);

        //neuralNetwork.setNetworkType(NeuralNetworkType.MULTI_LAYER_PERCEPTRON);
        neuralNetwork.setLearningRule(new BackPropagation());
        */
        neuralNetwork.save("neural_network.nnet");

        // System.out.println(neuralNetwork.getLayerAt(0).getNeuronAt(0).toString());
        /*
        // create new perceptron network
        NeuralNetwork neuralNetwork = new Perceptron(2, 1);
        // create training set
        DataSet trainingSet =
                new DataSet(2, 1);
        // add training data to training set (logical OR function)
        trainingSet. addRow (new DataSetRow (new double[]{0, 0},
                                                new double[]{0}));
        trainingSet. addRow (new DataSetRow (new double[]{0, 1},
                                                new double[]{1}));
        trainingSet. addRow (new DataSetRow(new double[]{1, 0},
                                                new double[]{1}));
        trainingSet. addRow (new DataSetRow (new double[]{1, 1},
                                                new double[]{1}));
        // learn the training set
        neuralNetwork.learn(trainingSet);
        // save the trained network into file
        neuralNetwork.save("or_perceptron.nnet");

        // load the saved network
        neuralNetwork = NeuralNetwork.load("or_perceptron.nnet");
        // set network input
        neuralNetwork.setInput(1, 1);
        // calculate network
        neuralNetwork.calculate();
        // get network output
        double[] networkOutput = neuralNetwork.getOutput();
        for(int i = 0; i < networkOutput.length; i++)
            System.out.println(networkOutput[i]);
        */
    }
}
