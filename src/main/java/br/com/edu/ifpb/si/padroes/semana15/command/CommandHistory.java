package br.com.edu.ifpb.si.padroes.semana15.command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }

}
