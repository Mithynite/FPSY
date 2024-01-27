package AnimationSettings;
import java.util.HashMap;
public class AnimationManager{
    private AnimationState currentState;
    private HashMap<AnimationState, AnimationGameObject> animap = new HashMap<>();
    public AnimationManager(AnimationState state) {
        this.currentState = state;
    }
    public void putNewAnimation(AnimationState type, AnimationGameObject animationEntity){
        animap.put(type,animationEntity);
    }
    public void changeState(AnimationState changed){
        currentState = changed;
    }
    public AnimationGameObject update(){
        return animap.get(currentState);
    }
    public boolean animationFinished(AnimationState required){
        return animap.get(required).animationIsFinished();
    }
    public void resetAnimationIndex(AnimationState currentState){
        animap.get(currentState).resetAnimationIndex();
    }
}
