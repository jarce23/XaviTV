package q3;

import i1.h0;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import l1.a0;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f10313a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(t tVar) {
        tVar.getClass();
        String k10 = tVar.k(StandardCharsets.UTF_8);
        return k10 != null && k10.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i10 = a0.f8067a;
        String[] split = str.split("\\.", 2);
        long j10 = 0;
        for (String str2 : split[0].split(":", -1)) {
            j10 = (j10 * 60) + Long.parseLong(str2);
        }
        long j11 = j10 * 1000;
        if (split.length == 2) {
            String trim = split[1].trim();
            if (trim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: ".concat(trim));
            }
            j11 += Long.parseLong(trim);
        }
        return j11 * 1000;
    }

    public static void d(t tVar) {
        int i10 = tVar.f8130b;
        if (a(tVar)) {
            return;
        }
        tVar.I(i10);
        throw h0.a(null, "Expected WEBVTT. Got " + tVar.k(StandardCharsets.UTF_8));
    }
}
