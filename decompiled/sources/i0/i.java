package i0;

import android.os.LocaleList;
import androidx.emoji2.text.b0;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f5789a;

    public i(Object obj) {
        this.f5789a = b0.f(obj);
    }

    @Override // i0.h
    public final String a() {
        String languageTags;
        languageTags = this.f5789a.toLanguageTags();
        return languageTags;
    }

    @Override // i0.h
    public final Object b() {
        return this.f5789a;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        equals = this.f5789a.equals(((h) obj).b());
        return equals;
    }

    @Override // i0.h
    public final Locale get(int i10) {
        Locale locale;
        locale = this.f5789a.get(i10);
        return locale;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f5789a.hashCode();
        return hashCode;
    }

    @Override // i0.h
    public final boolean isEmpty() {
        boolean isEmpty;
        isEmpty = this.f5789a.isEmpty();
        return isEmpty;
    }

    @Override // i0.h
    public final int size() {
        int size;
        size = this.f5789a.size();
        return size;
    }

    public final String toString() {
        String localeList;
        localeList = this.f5789a.toString();
        return localeList;
    }
}
