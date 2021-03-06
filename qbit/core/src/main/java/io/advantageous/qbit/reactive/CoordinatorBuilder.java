package io.advantageous.qbit.reactive;

import java.util.concurrent.TimeUnit;

/**
 * Coordinator Builder
 * Created by rhightower on 3/23/15.
 */
public class CoordinatorBuilder {


    public static CoordinatorBuilder coordinatorBuilder(final Reactor reactor) {
        return new CoordinatorBuilder(reactor);
    }

    final Reactor reactor;



    private CallbackCoordinator coordinator;
    private long startTime = -1;
    private long timeoutDuration = 5;
    private TimeUnit timeoutTimeUnit = TimeUnit.SECONDS;
    private Runnable timeOutHandler;

    public CoordinatorBuilder(Reactor reactor) {
        this.reactor = reactor;
    }


    public Reactor getReactor() {
        return reactor;
    }

    public CallbackCoordinator getCoordinator() {
        return coordinator;
    }

    public CoordinatorBuilder setCoordinator(CallbackCoordinator coordinator) {
        this.coordinator = coordinator;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public CoordinatorBuilder setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getTimeoutDuration() {
        return timeoutDuration;
    }

    public CoordinatorBuilder setTimeoutDuration(long timeoutDuration) {
        this.timeoutDuration = timeoutDuration;
        return this;
    }

    public TimeUnit getTimeoutTimeUnit() {
        return timeoutTimeUnit;
    }

    public CoordinatorBuilder setTimeoutTimeUnit(TimeUnit timeoutTimeUnit) {
        this.timeoutTimeUnit = timeoutTimeUnit;
        return this;
    }

    public Runnable getTimeOutHandler() {
        return timeOutHandler;
    }

    public CoordinatorBuilder setTimeOutHandler(Runnable timeOutHandler) {
        this.timeOutHandler = timeOutHandler;
        return this;
    }

    public CallbackCoordinator build() {
        return reactor.coordinateWithTimeout(coordinator, getStartTime(), getTimeoutDuration(),
                getTimeoutTimeUnit(), getTimeOutHandler());
    }
}
