package com.tw.step.rover.commands;

import com.tw.step.rover.rover.Rover;

@FunctionalInterface
public interface RoverCommand {
    void execute(Rover rover);
}
