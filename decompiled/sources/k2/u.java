package k2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f7780c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f7781a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f7782b = -1;

    public final boolean a(String str) {
        Matcher matcher = f7780c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i10 = l1.a0.f8067a;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f7781a = parseInt;
            this.f7782b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(i1.f0 f0Var) {
        int i10 = 0;
        while (true) {
            i1.e0[] e0VarArr = f0Var.f5876a;
            if (i10 >= e0VarArr.length) {
                return;
            }
            i1.e0 e0Var = e0VarArr[i10];
            if (e0Var instanceof y2.e) {
                y2.e eVar = (y2.e) e0Var;
                if ("iTunSMPB".equals(eVar.f13780c) && a(eVar.f13781d)) {
                    return;
                }
            } else if (e0Var instanceof y2.l) {
                y2.l lVar = (y2.l) e0Var;
                if ("com.apple.iTunes".equals(lVar.f13793b) && "iTunSMPB".equals(lVar.f13794c) && a(lVar.f13795d)) {
                    return;
                }
            } else {
                continue;
            }
            i10++;
        }
    }
}
