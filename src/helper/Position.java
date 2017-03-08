package helper;

/**
 * Created by andrew on 3/8/17.
 */
public class Position {
    public int x;
    public int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("X:");
        sb.append(x);
        sb.append("Y:");
        sb.append(y);

        return sb.toString().hashCode();
    }
}
