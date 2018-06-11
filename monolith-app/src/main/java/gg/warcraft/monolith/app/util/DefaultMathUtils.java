package gg.warcraft.monolith.app.util;

import gg.warcraft.monolith.api.util.MathUtils;
import gg.warcraft.monolith.api.world.block.BoundingBlockBox;
import gg.warcraft.monolith.app.world.block.SimpleBoundingBlockBox;
import org.joml.Vector3f;
import org.joml.Vector3ic;

import java.util.Random;

public class DefaultMathUtils implements MathUtils {
    private static final float TWO_PI = 2 * (float) Math.PI;

    private final Random random;

    public DefaultMathUtils() {
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public BoundingBlockBox createBoundingBlockBox(Vector3ic minimumCorner, Vector3ic maximumCorner) {
        return new SimpleBoundingBlockBox(minimumCorner, maximumCorner);
    }

    @Override
    public Vector3f randomVector() {
        float x = random.nextFloat() * 2f - 1f;
        float y = random.nextFloat() * 2f - 1f;
        float z = random.nextFloat() * 2f - 1f;
        Vector3f vector = new Vector3f(x, y, z);
        return vector.normalize();
    }

    @Override
    public Vector3f randomCircleVector() {
        float radian = randomAngle();
        float x = (float) Math.cos(radian);
        float z = (float) Math.sin(radian);
        return new Vector3f(x, 0f, z);
    }

    @Override
    public float randomAngle() {
        return random.nextFloat() * TWO_PI;
    }
}
