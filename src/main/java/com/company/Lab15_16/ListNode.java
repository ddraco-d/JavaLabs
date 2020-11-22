package com.company.Lab15_16;

public class ListNode<AnyType> {

    private ListNode pointers[] = new ListNode[2];
    private String command[] = new String[2];
    private int states[] = new int[2];

    public void set(int state, String command, ListNode pointer)
    {
        pointers[state] = pointer;
        this.command[state] = command;
        this.states[state] = state;
    }

    public ListNode[] getPointers() {
        return pointers;
    }

    public String[] getCommand() {
        return command;
    }

    public int[] getStates() {
        return states;
    }
}
