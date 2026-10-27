package j9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: h, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7403h = new androidx.emoji2.text.s("SliceMetadataManager", 3);

    /* renamed from: b, reason: collision with root package name */
    public final p f7405b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7406c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7407d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7408e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7409f;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7404a = new byte[8192];
    public int g = -1;

    public o1(p pVar, String str, int i10, long j10, String str2) {
        this.f7405b = pVar;
        this.f7406c = str;
        this.f7407d = i10;
        this.f7408e = j10;
        this.f7409f = str2;
    }

    public final int a() {
        p pVar = this.f7405b;
        pVar.getClass();
        File file = new File(new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f), "checkpoint.dat");
        if (!file.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new j0("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final t b() {
        p pVar = this.f7405b;
        pVar.getClass();
        File file = new File(new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f), "checkpoint.dat");
        if (!file.exists()) {
            throw new j0("Slice checkpoint file does not exist.");
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                throw new j0("Slice checkpoint file corrupt.");
            }
            try {
                int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                String property = properties.getProperty("fileName");
                long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                this.g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                return new t(parseInt, property, parseLong, parseLong2, parseInt2);
            } catch (NumberFormatException e7) {
                throw new j0("Slice checkpoint file corrupt.", e7);
            }
        } finally {
        }
    }

    public final File c() {
        p pVar = this.f7405b;
        pVar.getClass();
        File file = new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, this.g + "-NAM.dat");
    }

    public final void d(long j10, byte[] bArr, int i10, int i11) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        try {
            randomAccessFile.seek(j10);
            randomAccessFile.write(bArr, i10, i11);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void e(int i10) {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(c().length()));
        properties.put("previousChunk", String.valueOf(i10));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void f(String str, long j10, long j11, int i10) {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j10));
        properties.put("remainingBytes", String.valueOf(j11));
        properties.put("previousChunk", String.valueOf(i10));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void g(int i10, byte[] bArr) {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i10));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            p pVar = this.f7405b;
            pVar.getClass();
            File file = new File(new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f), "checkpoint_ext.dat");
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void h(int i10) {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i10));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream fileOutputStream = new FileOutputStream(l());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void i(byte[] bArr) {
        this.g++;
        p pVar = this.f7405b;
        pVar.getClass();
        File file = new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, this.g + "-LFH.dat"));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e7) {
            throw new j0("Could not write metadata file.", e7);
        }
    }

    public final void j(InputStream inputStream, byte[] bArr) {
        byte[] bArr2 = this.f7404a;
        this.g++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(bArr2);
            while (read > 0) {
                fileOutputStream.write(bArr2, 0, read);
                read = inputStream.read(bArr2);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void k(int i10, byte[] bArr) {
        this.g++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr, 0, i10);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final File l() {
        p pVar = this.f7405b;
        pVar.getClass();
        File file = new File(new File(new File(new File(pVar.c(this.f7407d, this.f7406c, this.f7408e), "_slices"), "_metadata"), this.f7409f), "checkpoint.dat");
        file.getParentFile().mkdirs();
        file.createNewFile();
        return file;
    }
}
