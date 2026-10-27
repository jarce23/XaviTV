package io.realm;

import io.realm.exceptions.RealmException;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f6662l;

    /* renamed from: m, reason: collision with root package name */
    public static final io.realm.internal.z f6663m;

    /* renamed from: a, reason: collision with root package name */
    public final File f6664a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6665b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6666c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6667d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6668e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6669f;
    public final io.realm.internal.z g;

    /* renamed from: h, reason: collision with root package name */
    public final ia.g f6670h;

    /* renamed from: i, reason: collision with root package name */
    public final long f6671i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f6672j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f6673k;

    static {
        Object obj;
        Object obj2 = u.f6839z;
        try {
            Constructor<?> constructor = DefaultRealmModule.class.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            obj = constructor.newInstance(null);
        } catch (ClassNotFoundException unused) {
            obj = null;
        } catch (IllegalAccessException e7) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e7);
        } catch (InstantiationException e8) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e8);
        } catch (InvocationTargetException e10) {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModule", e10);
        }
        f6662l = obj;
        if (obj == null) {
            f6663m = null;
            return;
        }
        io.realm.internal.z a10 = a(obj.getClass().getCanonicalName());
        if (!a10.j()) {
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://docs.mongodb.com/realm/sdk/android/install/#customize-dependecies-defined-by-the-realm-gradle-plugin");
        }
        f6663m = a10;
    }

    public f0(File file, long j10, boolean z10, int i10, io.realm.internal.z zVar, ia.f fVar, long j11, boolean z11, boolean z12) {
        this.f6664a = file.getParentFile();
        this.f6665b = file.getName();
        this.f6666c = file.getAbsolutePath();
        this.f6667d = j10;
        this.f6668e = z10;
        this.f6669f = i10;
        this.g = zVar;
        this.f6670h = fVar;
        this.f6671i = j11;
        this.f6672j = z11;
        this.f6673k = z12;
    }

    public static io.realm.internal.z a(String str) {
        String[] split = str.split("\\.");
        String str2 = split[split.length - 1];
        Locale locale = Locale.US;
        String q10 = android.support.v4.media.d.q("io.realm.", str2, "Mediator");
        try {
            Constructor<?> constructor = Class.forName(q10).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (io.realm.internal.z) constructor.newInstance(null);
        } catch (ClassNotFoundException e7) {
            throw new RealmException("Could not find ".concat(q10), e7);
        } catch (IllegalAccessException e8) {
            throw new RealmException("Could not create an instance of ".concat(q10), e8);
        } catch (InstantiationException e10) {
            throw new RealmException("Could not create an instance of ".concat(q10), e10);
        } catch (InvocationTargetException e11) {
            throw new RealmException("Could not create an instance of ".concat(q10), e11);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f0.class != obj.getClass()) {
            return false;
        }
        f0 f0Var = (f0) obj;
        ia.g gVar = f0Var.f6670h;
        String str = f0Var.f6665b;
        File file = f0Var.f6664a;
        if (this.f6667d != f0Var.f6667d || this.f6668e != f0Var.f6668e) {
            return false;
        }
        File file2 = this.f6664a;
        if (file2 != null) {
            if (!file2.equals(file)) {
                return false;
            }
        } else if (file != null) {
            return false;
        }
        String str2 = this.f6665b;
        if (str2 != null) {
            if (!str2.equals(str)) {
                return false;
            }
        } else if (str != null) {
            return false;
        }
        if (!this.f6666c.equals(f0Var.f6666c) || !Arrays.equals((byte[]) null, (byte[]) null) || this.f6669f != f0Var.f6669f || !this.g.equals(f0Var.g)) {
            return false;
        }
        if (this.f6670h != null) {
            if (!(gVar instanceof ia.f)) {
                return false;
            }
        } else if (gVar != null) {
            return false;
        }
        return this.f6671i == f0Var.f6671i;
    }

    public final int hashCode() {
        File file = this.f6664a;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        String str = this.f6665b;
        int hashCode2 = (Arrays.hashCode((byte[]) null) + android.support.v4.media.d.g(this.f6666c, (hashCode + (str != null ? str.hashCode() : 0)) * 31, 961)) * 31;
        long j10 = this.f6667d;
        int hashCode3 = (this.g.hashCode() + ((s.e.b(this.f6669f) + ((((hashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 961) + (this.f6668e ? 1 : 0)) * 31)) * 31)) * 31;
        int i10 = this.f6670h != null ? 37 : 0;
        long j11 = this.f6671i;
        return ((hashCode3 + i10) * 28629151) + ((int) ((j11 >>> 32) ^ j11));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("realmDirectory: ");
        File file = this.f6664a;
        sb2.append(file != null ? file.toString() : _UrlKt.FRAGMENT_ENCODE_SET);
        sb2.append("\nrealmFileName : ");
        sb2.append(this.f6665b);
        sb2.append("\ncanonicalPath: ");
        sb2.append(this.f6666c);
        sb2.append("\nkey: [length: ");
        sb2.append(0);
        sb2.append("]\nschemaVersion: ");
        sb2.append(Long.toString(this.f6667d));
        sb2.append("\nmigration: null\ndeleteRealmIfMigrationNeeded: ");
        sb2.append(this.f6668e);
        sb2.append("\ndurability: ");
        int i10 = this.f6669f;
        sb2.append(i10 != 1 ? i10 != 2 ? "null" : "MEM_ONLY" : "FULL");
        sb2.append("\nschemaMediator: ");
        sb2.append(this.g);
        sb2.append("\nreadOnly: false\ncompactOnLaunch: null\nmaxNumberOfActiveVersions: ");
        sb2.append(this.f6671i);
        return sb2.toString();
    }
}
