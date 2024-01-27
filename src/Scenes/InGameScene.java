package Scenes;

public enum InGameScene {
    Shop,Gameplay;
    private static InGameScene currentInGameScene = Gameplay;
    public static InGameScene getCurrentInGameScene() {
        return currentInGameScene;
    }
    public static void setCurrentInGameScene(InGameScene requiredInGameScene) {
        InGameScene.currentInGameScene = requiredInGameScene;
    }
}
