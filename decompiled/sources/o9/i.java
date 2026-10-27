package o9;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i extends d implements SortedMap {

    /* renamed from: s, reason: collision with root package name */
    public SortedSet f9621s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ s0 f9622t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(s0 s0Var, SortedMap sortedMap) {
        super(s0Var, sortedMap);
        this.f9622t = s0Var;
    }

    public SortedSet b() {
        return new j(this.f9622t, d());
    }

    @Override // o9.d, java.util.AbstractMap, java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f9621s;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet b2 = b();
        this.f9621s = b2;
        return b2;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return d().comparator();
    }

    public SortedMap d() {
        return (SortedMap) this.f9600q;
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return d().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new i(this.f9622t, d().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return d().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new i(this.f9622t, d().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new i(this.f9622t, d().tailMap(obj));
    }
}
