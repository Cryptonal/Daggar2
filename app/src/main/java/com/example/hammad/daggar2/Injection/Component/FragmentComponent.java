package com.example.hammad.daggar2.Injection.Component;

import com.example.hammad.daggar2.Module.FragmentModule;
import com.example.hammad.daggar2.Injection.PerFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}
