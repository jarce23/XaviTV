package o9;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j extends e implements SortedSet {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ s0 f9624q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s0 s0Var, SortedMap sortedMap) {
        super(s0Var, sortedMap);
        this.f9624q = s0Var;
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return f().comparator();
    }

    public SortedMap f() {
        return (SortedMap) this.f9603o;
    }

    @Override // java.util.SortedSet
    public final Object first() {
        return f().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new j(this.f9624q, f().headMap(obj));
    }

    @Override // java.util.SortedSet
    public final Object last() {
        return f().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new j(this.f9624q, f().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new j(this.f9624q, f().tailMap(obj));
    }
}
