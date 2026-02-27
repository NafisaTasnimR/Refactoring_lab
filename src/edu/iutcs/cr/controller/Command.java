package edu.iutcs.cr.controller;

/**
 * Functional interface representing a single executable menu operation.
 * Used with the Command Pattern to eliminate switch/if-else dispatch.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
@FunctionalInterface
public interface Command {
    void execute();
}
