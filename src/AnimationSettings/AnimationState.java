package AnimationSettings;

public enum AnimationState {
    idle, walk, attack, hurt, die;
    private static AnimationState currentAS = idle;
    public static AnimationState getCurrentAS() {
        return currentAS;
    }

    public static void setCurrentGameScene(AnimationState currentAS) {
        AnimationState.currentAS = currentAS;
    }
}
