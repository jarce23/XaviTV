package x4;

import a6.m0;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.View;
import j9.g1;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: o, reason: collision with root package name */
    public static Boolean f13544o;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f13545p;

    /* renamed from: q, reason: collision with root package name */
    public static Boolean f13546q;

    /* renamed from: r, reason: collision with root package name */
    public static Boolean f13547r;

    public static File A(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i10 = 0; i10 < 100; i10++) {
            File file = new File(cacheDir, str + i10);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static int B(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 8) {
            return 3;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 32) {
            return 5;
        }
        if (i10 == 64) {
            return 6;
        }
        if (i10 == 128) {
            return 7;
        }
        if (i10 == 256) {
            return 8;
        }
        if (i10 == 512) {
            return 9;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static boolean D(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f13544o == null) {
            f13544o = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (f13544o.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (f13545p == null) {
            f13545p = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f13545p.booleanValue()) {
            return !y7.d.k() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static MappedByteBuffer E(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static m5.b H(c4.e eVar) {
        long j10;
        boolean z10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = (Map) eVar.f2877q;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long J = str != null ? J(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z10 = false;
            j11 = 0;
            j12 = 0;
            while (i10 < split.length) {
                String trim = split[i10].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i10++;
            }
            j10 = 0;
            i10 = 1;
        } else {
            j10 = 0;
            z10 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = (String) map.get("Expires");
        long J2 = str3 != null ? J(str3) : j10;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j13 = currentTimeMillis;
            j14 = J(str4);
        } else {
            j13 = currentTimeMillis;
            j14 = j10;
        }
        String str5 = (String) map.get("ETag");
        if (i10 != 0) {
            long j17 = (j11 * 1000) + j13;
            if (z10) {
                j16 = j17;
            } else {
                Long.signum(j12);
                j16 = (j12 * 1000) + j17;
            }
            j15 = j17;
        } else {
            j15 = (J <= j10 || J2 < J) ? j10 : (J2 - J) + j13;
            j16 = j15;
        }
        m5.b bVar = new m5.b();
        bVar.f8950a = (byte[]) eVar.f2876p;
        bVar.f8951b = str5;
        bVar.f8955f = j15;
        bVar.f8954e = j16;
        bVar.f8952c = J;
        bVar.f8953d = j14;
        bVar.g = map;
        bVar.f8956h = (List) eVar.f2878r;
        return bVar;
    }

    public static String I(String str, Map map) {
        String str2;
        if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
            String[] split = str2.split(";", 0);
            for (int i10 = 1; i10 < split.length; i10++) {
                String[] split2 = split[i10].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long J(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e7) {
            if ("0".equals(str) || "-1".equals(str)) {
                m5.p.d("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            Log.e("Volley", m5.p.a("Unable to parse dateStr: %s, falling back to 0", str), e7);
            return 0L;
        }
    }

    public static boolean K(Parcel parcel, int i10) {
        X(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean L(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        if (R == 0) {
            return null;
        }
        Y(parcel, R);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double M(Parcel parcel, int i10) {
        X(parcel, i10, 8);
        return parcel.readDouble();
    }

    public static IBinder N(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + R);
        return readStrongBinder;
    }

    public static int O(Parcel parcel, int i10) {
        X(parcel, i10, 4);
        return parcel.readInt();
    }

    public static Integer P(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        if (R == 0) {
            return null;
        }
        Y(parcel, R);
        return Integer.valueOf(parcel.readInt());
    }

    public static long Q(Parcel parcel, int i10) {
        X(parcel, i10, 8);
        return parcel.readLong();
    }

    public static int R(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static long T(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j11) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j10);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        long j12 = ((j10 ^ j11) >>> 63) + Long.MAX_VALUE;
        if (!((numberOfLeadingZeros < 64) | ((j11 == Long.MIN_VALUE) & (j10 < 0)))) {
            long j13 = j10 * j11;
            if (j10 == 0 || j13 / j10 == j11) {
                return j13;
            }
        }
        return j12;
    }

    public static void U(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + R(parcel, i10));
    }

    public static int V(Parcel parcel) {
        int readInt = parcel.readInt();
        int R = R(parcel, readInt);
        char c10 = (char) readInt;
        int dataPosition = parcel.dataPosition();
        if (c10 != 20293) {
            throw new m0("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
        }
        int i10 = R + dataPosition;
        if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(dataPosition).length() + 32 + String.valueOf(i10).length());
        sb2.append("Size read is invalid start=");
        sb2.append(dataPosition);
        sb2.append(" end=");
        sb2.append(i10);
        throw new m0(sb2.toString(), parcel);
    }

    public static int W(int i10, int i11) {
        if (i11 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i12 = i10 + (i10 >> 1) + 1;
        if (i12 < i11) {
            int highestOneBit = Integer.highestOneBit(i11 - 1);
            i12 = highestOneBit + highestOneBit;
        }
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        return i12;
    }

    public static void X(Parcel parcel, int i10, int i11) {
        int R = R(parcel, i10);
        if (R == i11) {
            return;
        }
        String hexString = Integer.toHexString(R);
        int length = String.valueOf(i11).length();
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(R).length() + 4 + 1);
        sb2.append("Expected size ");
        sb2.append(i11);
        sb2.append(" got ");
        sb2.append(R);
        sb2.append(" (0x");
        sb2.append(hexString);
        sb2.append(")");
        throw new m0(sb2.toString(), parcel);
    }

    public static void Y(Parcel parcel, int i10) {
        if (i10 == 4) {
            return;
        }
        String hexString = Integer.toHexString(i10);
        int length = String.valueOf(4).length();
        int length2 = String.valueOf(i10).length();
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + length + 19 + length2 + 4 + 1);
        sb2.append("Expected size 4 got ");
        sb2.append(i10);
        sb2.append(" (0x");
        sb2.append(hexString);
        sb2.append(")");
        throw new m0(sb2.toString(), parcel);
    }

    public static long h(long j10, long j11) {
        long j12 = j10 + j11;
        if (((j10 ^ j11) < 0) || ((j10 ^ j12) >= 0)) {
            return j12;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + j10 + ", " + j11 + ")");
    }

    public static void i(kb.e eVar) {
        eVar.j(null, false);
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean k(File file, Resources resources, int i10) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i10);
            try {
                boolean l10 = l(file, inputStream);
                j(inputStream);
                return l10;
            } catch (Throwable th) {
                th = th;
                j(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static boolean l(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    j(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            j(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            j(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static Bundle m(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + R);
        return readBundle;
    }

    public static int[] n(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + R);
        return createIntArray;
    }

    public static long[] o(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + R);
        return createLongArray;
    }

    public static Parcelable p(Parcel parcel, int i10, Parcelable.Creator creator) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + R);
        return parcelable;
    }

    public static String q(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + R);
        return readString;
    }

    public static ArrayList r(Parcel parcel, int i10) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + R);
        return createStringArrayList;
    }

    public static Object[] s(Parcel parcel, int i10, Parcelable.Creator creator) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + R);
        return createTypedArray;
    }

    public static ArrayList t(Parcel parcel, int i10, Parcelable.Creator creator) {
        int R = R(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (R == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + R);
        return createTypedArrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (r8 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long u(long r8, long r10, java.math.RoundingMode r12) {
        /*
            r12.getClass()
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            goto L53
        L10:
            long r8 = r8 ^ r10
            r7 = 63
            long r8 = r8 >> r7
            int r8 = (int) r8
            r8 = r8 | 1
            int[] r9 = q9.d.f10373a
            int r7 = r12.ordinal()
            r9 = r9[r7]
            switch(r9) {
                case 1: goto L51;
                case 2: goto L53;
                case 3: goto L4c;
                case 4: goto L4e;
                case 5: goto L49;
                case 6: goto L28;
                case 7: goto L28;
                case 8: goto L28;
                default: goto L22;
            }
        L22:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L28:
            long r2 = java.lang.Math.abs(r2)
            long r9 = java.lang.Math.abs(r10)
            long r9 = r9 - r2
            long r2 = r2 - r9
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 != 0) goto L46
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_UP
            if (r12 == r9) goto L4e
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r9) goto L53
            r9 = 1
            long r9 = r9 & r0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 == 0) goto L53
            goto L4e
        L46:
            if (r9 <= 0) goto L53
            goto L4e
        L49:
            if (r8 <= 0) goto L53
            goto L4e
        L4c:
            if (r8 >= 0) goto L53
        L4e:
            long r8 = (long) r8
            long r0 = r0 + r8
            return r0
        L51:
            if (r6 != 0) goto L54
        L53:
            return r0
        L54:
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
            java.lang.String r9 = "mode was UNNECESSARY, but rounding was necessary"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.f.u(long, long, java.math.RoundingMode):long");
    }

    public static boolean v(Context context) {
        boolean isHdr;
        Display.HdrCapabilities hdrCapabilities;
        int[] supportedHdrTypes;
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display != null) {
            isHdr = display.isHdr();
            if (isHdr) {
                hdrCapabilities = display.getHdrCapabilities();
                supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
                for (int i10 : supportedHdrTypes) {
                    if (i10 == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void w(Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 26);
        sb2.append("Overread allowed size end=");
        sb2.append(i10);
        throw new m0(sb2.toString(), parcel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        r2 = r2.getSupportedPerformancePoints();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int x(boolean r4) {
        /*
            r0 = 0
            i1.o r1 = new i1.o     // Catch: z1.u -> L85
            r1.<init>()     // Catch: z1.u -> L85
            java.lang.String r2 = "video/avc"
            java.lang.String r2 = i1.g0.m(r2)     // Catch: z1.u -> L85
            r1.f5940m = r2     // Catch: z1.u -> L85
            i1.p r2 = new i1.p     // Catch: z1.u -> L85
            r2.<init>(r1)     // Catch: z1.u -> L85
            java.lang.String r1 = r2.f5991n     // Catch: z1.u -> L85
            if (r1 == 0) goto L85
            java.util.List r1 = z1.x.d(r1, r4, r0)     // Catch: z1.u -> L85
            java.lang.String r2 = z1.x.b(r2)     // Catch: z1.u -> L85
            if (r2 != 0) goto L24
            o9.w0 r4 = o9.w0.f9686s     // Catch: z1.u -> L85
            goto L28
        L24:
            java.util.List r4 = z1.x.d(r2, r4, r0)     // Catch: z1.u -> L85
        L28:
            o9.d0 r2 = o9.g0.m()     // Catch: z1.u -> L85
            r2.c(r1)     // Catch: z1.u -> L85
            r2.c(r4)     // Catch: z1.u -> L85
            o9.w0 r4 = r2.f()     // Catch: z1.u -> L85
            r1 = r0
        L37:
            int r2 = r4.f9688r     // Catch: z1.u -> L85
            if (r1 >= r2) goto L85
            java.lang.Object r2 = r4.get(r1)     // Catch: z1.u -> L85
            z1.p r2 = (z1.p) r2     // Catch: z1.u -> L85
            android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f14003d     // Catch: z1.u -> L85
            if (r2 == 0) goto L82
            java.lang.Object r2 = r4.get(r1)     // Catch: z1.u -> L85
            z1.p r2 = (z1.p) r2     // Catch: z1.u -> L85
            android.media.MediaCodecInfo$CodecCapabilities r2 = r2.f14003d     // Catch: z1.u -> L85
            android.media.MediaCodecInfo$VideoCapabilities r2 = r2.getVideoCapabilities()     // Catch: z1.u -> L85
            if (r2 == 0) goto L82
            java.util.List r2 = v8.a.f(r2)     // Catch: z1.u -> L85
            if (r2 == 0) goto L82
            boolean r3 = r2.isEmpty()     // Catch: z1.u -> L85
            if (r3 != 0) goto L82
            v8.a.g()     // Catch: z1.u -> L85
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = v8.a.b()     // Catch: z1.u -> L85
            r1 = r0
        L67:
            int r3 = r2.size()     // Catch: z1.u -> L85
            if (r1 >= r3) goto L80
            java.lang.Object r3 = r2.get(r1)     // Catch: z1.u -> L85
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r3 = v8.a.d(r3)     // Catch: z1.u -> L85
            boolean r3 = v8.a.j(r3, r4)     // Catch: z1.u -> L85
            if (r3 == 0) goto L7d
            r4 = 2
            return r4
        L7d:
            int r1 = r1 + 1
            goto L67
        L80:
            r4 = 1
            return r4
        L82:
            int r1 = r1 + 1
            goto L37
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.f.x(boolean):int");
    }

    public static long y(long j10, long j11) {
        y7.d.c(j10, "a");
        y7.d.c(j11, "b");
        if (j10 == 0) {
            return j11;
        }
        if (j11 == 0) {
            return j10;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j12 = j10 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j11);
        long j13 = j11 >> numberOfTrailingZeros2;
        while (j12 != j13) {
            long j14 = j12 - j13;
            long j15 = (j14 >> 63) & j14;
            long j16 = (j14 - j15) - j15;
            j13 += j15;
            j12 = j16 >> Long.numberOfTrailingZeros(j16);
        }
        return j12 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static Calendar z(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public abstract View F(int i10);

    public abstract boolean G();

    public o7.c d(Context context, Looper looper, g1 g1Var, Object obj, o7.g gVar, o7.h hVar) {
        return g(context, looper, g1Var, obj, (p7.k) gVar, (p7.k) hVar);
    }

    public o7.c g(Context context, Looper looper, g1 g1Var, Object obj, p7.k kVar, p7.k kVar2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public void C() {
    }

    public void c() {
    }

    public void S(Context context, com.bumptech.glide.b bVar, com.bumptech.glide.k kVar) {
    }
}
