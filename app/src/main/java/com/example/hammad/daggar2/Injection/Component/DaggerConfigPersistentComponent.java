package com.example.hammad.daggar2.Injection.Component;

import com.example.hammad.daggar2.Data.DataManager;
import com.example.hammad.daggar2.Module.ActivityModule;
import com.example.hammad.daggar2.Module.FragmentModule;

import javax.inject.Provider;

import dagger.internal.Preconditions;

public class DaggerConfigPersistentComponent implements ConfigPersistentComponent{
    private AppComponent appComponent;
    private dataManager dataManager;
    private DaggerConfigPersistentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(final Builder builder) {
        this.appComponent = builder.appComponent;
        this.dataManager = new dataManager(builder.appComponent);
    }

    private static class dataManager implements Provider<DataManager>{

        private final AppComponent appComponent;

        dataManager(AppComponent appComponent){
            this.appComponent = appComponent;
        }
        @Override
        public DataManager get() {
            return Preconditions.checkNotNull(
                    appComponent.dataManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    @Override
    public ActivityComponent activityComponent(ActivityModule activityModule) {
        return new ActivityComponentImpl(activityModule);
    }

    @Override
    public FragmentComponent fragmentComponent(FragmentModule fragmentModule) {
        return new FragmentComponentImpl(fragmentModule);
    }

    public static final class Builder {
        private AppComponent appComponent;

        private Builder() {}

        public ConfigPersistentComponent build() {
            if (appComponent == null) {
                throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
            }
            return new DaggerConfigPersistentComponent(this);
        }

        public Builder appComponent(AppComponent appComponent) {
            this.appComponent = Preconditions.checkNotNull(appComponent);
            return this;
        }
    }

    private final class ActivityComponentImpl implements ActivityComponent {
        private final ActivityModule activityModule;

        private ActivityComponentImpl(ActivityModule activityModule) {
            this.activityModule = Preconditions.checkNotNull(activityModule);
        }
    }

    private final class FragmentComponentImpl implements FragmentComponent {
        private final FragmentModule fragmentModule;

        private FragmentComponentImpl(FragmentModule fragmentModule) {
            this.fragmentModule = Preconditions.checkNotNull(fragmentModule);
        }
    }
}
