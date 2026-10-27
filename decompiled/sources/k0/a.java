package k0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f7579e = new byte[1792];

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f7580a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7581b;

    /* renamed from: c, reason: collision with root package name */
    public int f7582c;

    /* renamed from: d, reason: collision with root package name */
    public char f7583d;

    static {
        for (int i10 = 0; i10 < 1792; i10++) {
            f7579e[i10] = Character.getDirectionality(i10);
        }
    }

    public a(CharSequence charSequence) {
        this.f7580a = charSequence;
        this.f7581b = charSequence.length();
    }

    public final byte a() {
        int i10 = this.f7582c - 1;
        CharSequence charSequence = this.f7580a;
        char charAt = charSequence.charAt(i10);
        this.f7583d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f7582c);
            this.f7582c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f7582c--;
        char c10 = this.f7583d;
        return c10 < 1792 ? f7579e[c10] : Character.getDirectionality(c10);
    }
}
