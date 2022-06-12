package com.co.ias.project.animales.commons;
public interface UseCase<Input, Output> {
    Output execute(Input input);
}
