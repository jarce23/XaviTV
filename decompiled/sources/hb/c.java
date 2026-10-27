package hb;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static final c f5770p;

    /* renamed from: q, reason: collision with root package name */
    public static final c f5771q;

    /* renamed from: r, reason: collision with root package name */
    public static final c f5772r;

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ c[] f5773s;

    /* renamed from: o, reason: collision with root package name */
    public final TimeUnit f5774o;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f5770p = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        f5771q = cVar3;
        c cVar4 = new c("SECONDS", 3, TimeUnit.SECONDS);
        f5772r = cVar4;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, new c("MINUTES", 4, TimeUnit.MINUTES), new c("HOURS", 5, TimeUnit.HOURS), new c("DAYS", 6, TimeUnit.DAYS)};
        f5773s = cVarArr;
        a.a.k(cVarArr);
    }

    public c(String str, int i10, TimeUnit timeUnit) {
        this.f5774o = timeUnit;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f5773s.clone();
    }
}
