package okhttp3.internal;

import fb.e;
import java.util.Collections;
import java.util.List;
import ma.j;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class LinkedTags<K> extends Tags {
    private final eb.b key;
    private final Tags next;
    private final K value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedTags(eb.b bVar, K k10, Tags tags) {
        super(null);
        h.e("key", bVar);
        h.e("value", k10);
        h.e("next", tags);
        this.key = bVar;
        this.value = k10;
        this.next = tags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkedTags toString$lambda$0(LinkedTags linkedTags) {
        h.e("it", linkedTags);
        Tags tags = linkedTags.next;
        if (tags instanceof LinkedTags) {
            return (LinkedTags) tags;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$1(LinkedTags linkedTags) {
        h.e("it", linkedTags);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(linkedTags.key);
        sb2.append('=');
        sb2.append(linkedTags.value);
        return sb2.toString();
    }

    @Override // okhttp3.internal.Tags
    public <T> T get(eb.b bVar) {
        h.e("key", bVar);
        return bVar.equals(this.key) ? (T) k5.a.o(bVar).cast(this.value) : (T) this.next.get(bVar);
    }

    @Override // okhttp3.internal.Tags
    public <T> Tags plus(eb.b bVar, T t3) {
        Tags linkedTags;
        h.e("key", bVar);
        if (bVar.equals(this.key)) {
            linkedTags = this.next;
        } else {
            Tags plus = this.next.plus(bVar, null);
            linkedTags = plus == this.next ? this : new LinkedTags(this.key, this.value, plus);
        }
        return t3 != null ? new LinkedTags(bVar, t3, linkedTags) : linkedTags;
    }

    public String toString() {
        List K;
        List A = fb.h.A(new e(new androidx.activity.e(1, this), new a(0)));
        if (A.size() <= 1) {
            K = j.J(A);
        } else {
            K = j.K(A);
            Collections.reverse(K);
        }
        return j.F(K, null, "{", "}", new a(1), 25);
    }
}
