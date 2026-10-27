package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f575j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static volatile l f576k;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f577a;

    /* renamed from: b, reason: collision with root package name */
    public final p.f f578b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f579c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f580d;

    /* renamed from: e, reason: collision with root package name */
    public final f f581e;

    /* renamed from: f, reason: collision with root package name */
    public final k f582f;
    public final d9.f g;

    /* renamed from: h, reason: collision with root package name */
    public final int f583h;

    /* renamed from: i, reason: collision with root package name */
    public final d f584i;

    public l(v vVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f577a = reentrantReadWriteLock;
        this.f579c = 3;
        k kVar = (k) vVar.f570b;
        this.f582f = kVar;
        int i10 = vVar.f569a;
        this.f583h = i10;
        this.f584i = (d) vVar.f571c;
        this.f580d = new Handler(Looper.getMainLooper());
        this.f578b = new p.f(0);
        this.g = new d9.f(5);
        f fVar = new f(this);
        this.f581e = fVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i10 == 0) {
            try {
                this.f579c = 0;
            } catch (Throwable th) {
                this.f577a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                kVar.a(new e(fVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static l a() {
        l lVar;
        synchronized (f575j) {
            try {
                lVar = f576k;
                if (!(lVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return lVar;
    }

    public final int b() {
        this.f577a.readLock().lock();
        try {
            return this.f579c;
        } finally {
            this.f577a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.f583h == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f577a.writeLock().lock();
        try {
            if (this.f579c == 0) {
                return;
            }
            this.f579c = 0;
            this.f577a.writeLock().unlock();
            f fVar = this.f581e;
            l lVar = fVar.f566a;
            try {
                lVar.f582f.a(new e(fVar));
            } catch (Throwable th) {
                lVar.d(th);
            }
        } finally {
            this.f577a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f577a.writeLock().lock();
        try {
            this.f579c = 2;
            arrayList.addAll(this.f578b);
            this.f578b.clear();
            this.f577a.writeLock().unlock();
            this.f580d.post(new j(arrayList, this.f579c, th));
        } catch (Throwable th2) {
            this.f577a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:28:0x005a, B:31:0x005f, B:33:0x0063, B:35:0x0070, B:37:0x008f, B:39:0x0099, B:41:0x009c, B:43:0x009f, B:45:0x00af, B:46:0x00b2), top: B:27:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.CharSequence e(java.lang.CharSequence r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.l.e(java.lang.CharSequence, int, int):java.lang.CharSequence");
    }

    public final void f(i iVar) {
        y7.d.d("initCallback cannot be null", iVar);
        this.f577a.writeLock().lock();
        try {
            if (this.f579c != 1 && this.f579c != 2) {
                this.f578b.add(iVar);
                this.f577a.writeLock().unlock();
            }
            this.f580d.post(new j(Arrays.asList(iVar), this.f579c, (Throwable) null));
            this.f577a.writeLock().unlock();
        } catch (Throwable th) {
            this.f577a.writeLock().unlock();
            throw th;
        }
    }
}
