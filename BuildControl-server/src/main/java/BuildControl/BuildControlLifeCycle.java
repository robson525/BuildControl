package BuildControl;

import jetbrains.buildServer.serverSide.*;
import jetbrains.buildServer.util.EventDispatcher;
import org.jetbrains.annotations.NotNull;

public class BuildControlLifeCycle extends BuildServerAdapter {

    public BuildControlLifeCycle(@NotNull EventDispatcher<BuildServerListener> events) {
        events.addListener(this);
    }

    @Override
    public void buildTypeAddedToQueue(@NotNull SQueuedBuild queuedBuild) {
        if(queuedBuild.getBuildType().isPaused())
            queuedBuild.removeFromQueue(null, "ROBSON.BuildControl.BuildControlLifeCycle - The buildType is paused. ");
    }

}
