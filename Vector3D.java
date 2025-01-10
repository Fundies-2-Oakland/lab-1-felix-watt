
public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        double mag = getMagnitude();
        if (mag == 0) {
            throw new IllegalStateException("Magnitude is 0");
        }
        return new Vector3D(x / mag, y / mag, z / mag);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3D multiply(double c) {
        return new Vector3D(x * c, y * c, z * c);
    }

    public double dotProduct(Vector3D other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public double angleBetween(Vector3D other) {
        double dp = dotProduct(other);
        double denom = getMagnitude() * other.getMagnitude();
        return Math.acos(dp / denom);
    }

    public Vector3D crossProduct(Vector3D other) {
        double ux = y * other.getZ() - z * other.getY();
        double uy = z * other.getX() - x * other.getZ();
        double uz = x * other.getY() - y * other.getX();

        return new Vector3D(ux, uy, uz);

    }

    @Override
    public String toString() {
        return "Vector with x:" + x + ", y:" + y + ", z:" + z;
    }
}
