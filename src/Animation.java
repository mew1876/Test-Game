package bin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Animation {
    private int frameTime;
    private int frameDelay;
    private int currentFrame;
    private int animationDirection;
    private int totalFrames;
    private int skipTo;

    private boolean stopped;

    private ArrayList<Frame> frames = new ArrayList<Frame>();

    public Animation(BufferedImage[] images, int frameDelay) {
        stopped = true;

        for (int i = 0; i < images.length; i++) {
            addFrame(images[i], frameDelay);
        }

        frameTime = 0;
        this.frameDelay = frameDelay;
        currentFrame = 0;
        animationDirection = 1;
        totalFrames = frames.size();
        skipTo = 0;
    }

    public Animation(BufferedImage[] images, int frameDelay, int skipTo) {
        stopped = true;

        for (int i = 0; i < images.length; i++) {
            addFrame(images[i], frameDelay);
        }

        frameTime = 0;
        this.frameDelay = frameDelay;
        currentFrame = 0;
        animationDirection = 1;
        totalFrames = frames.size();
        this.skipTo = skipTo;
    }

    public void start() {
        if (!stopped || frames.size() == 0) {
            return;
        }

        stopped = false;
    }

    public void stop() {
        if (frames.size() == 0) {
            return;
        }

        stopped = true;
    }

    public void restart() {
        if (frames.size() == 0) {
            return;
        }

        stopped = false;
        currentFrame = 0;
    }

    public void reset() {
        this.stopped = true;
        this.frameTime = 0;
        this.currentFrame = 0;
    }

    private void addFrame(BufferedImage frame, int duration) {
        if (duration <= 0) {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }

        frames.add(new Frame(frame, duration));
        currentFrame = 0;
    }

    public BufferedImage getSprite() {
        return frames.get(currentFrame).getFrame();
    }

    public void update() {
        if (!stopped) {
            frameTime++;

            if (frameTime > frameDelay) {
                frameTime = 0;
                currentFrame += animationDirection;

                if (currentFrame > totalFrames - 1) {
                    currentFrame = skipTo;
                }
                else if (currentFrame < 0) {
                    currentFrame = totalFrames - 1;
                }
            }
        }
    }
}