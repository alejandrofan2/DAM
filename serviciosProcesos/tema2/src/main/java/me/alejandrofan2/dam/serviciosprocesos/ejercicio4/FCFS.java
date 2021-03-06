package me.alejandrofan2.dam.serviciosprocesos.ejercicio4;

import java.util.Scanner;

public class FCFS {

    private final Scanner in = new Scanner(System.in);

    int pid[];// id proceso
    int arrivalTime[]; // tiempo de llegada
    int burstTime[]; // numero de veces ejecutado
    int completionTime[]; // tiempo de completado
    int turnArround[]; // turn around times
    int waitingTime[]; // tiempo de espera
    float avgWaitingTime = 0;
    float avgTimeArround = 0;

    public FCFS() {
        super();

        init();
    }

    private void init() {
        System.out.print("enter nº of process: ");
        int n = in.nextInt();
        pid = new int[n];
        arrivalTime = new int[n];
        burstTime = new int[n];
        completionTime = new int[n];
        turnArround = new int[n];
        waitingTime = new int[n];
        int temp;

        for (int i = 0; i < n; i++) {
            System.out.print("enter process " + (i + 1) + " arrival time: ");
            arrivalTime[i] = in.nextInt();
            System.out.print("enter process " + (i + 1) + " brust time: ");
            burstTime[i] = in.nextInt();
            pid[i] = i + 1;
        }

        // sorting according to arrival times
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (arrivalTime[j] > arrivalTime[j + 1]) {
                    temp = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j + 1];
                    arrivalTime[j + 1] = temp;
                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }
        end(n);
    }

    private void end(int nProcess) {
        // finding completion times
        for (int i = 0; i < nProcess; i++) {
            if (i == 0) {
                completionTime[i] = arrivalTime[i] + burstTime[i];
            } else {
                if (arrivalTime[i] > completionTime[i - 1]) {
                    completionTime[i] = arrivalTime[i] + burstTime[i];
                } else
                    completionTime[i] = completionTime[i - 1] + burstTime[i];
            }
            turnArround[i] = completionTime[i] - arrivalTime[i]; // turnaround time= completion time- arrival time
            waitingTime[i] = turnArround[i] - burstTime[i]; // waiting time= turnaround time- burst time
            avgWaitingTime += waitingTime[i]; // total waiting time
            avgTimeArround += turnArround[i]; // total turnaround time
        }
        System.out.print("\npid  arrival  brust  complete turn waiting");
        for (int i = 0; i < nProcess; i++) {
            System.out.print("\n" + pid[i] + "  \t " + arrivalTime[i] + "\t" + burstTime[i] + "\t" + completionTime[i]
                    + "\t" + turnArround[i] + "\t" + waitingTime[i]);
        }
        in.close();
        System.out.print("\nAverage waiting time: " + (avgWaitingTime / nProcess));
        System.out.print("\nAverage turnaround time:" + (avgTimeArround / nProcess));
    }

    @Override
    public String toString() {
        return "FCFS []";
    }
}
