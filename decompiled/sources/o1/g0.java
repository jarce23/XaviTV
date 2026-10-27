package o1;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g0 extends c {
    public int A;

    /* renamed from: s, reason: collision with root package name */
    public final int f9405s;

    /* renamed from: t, reason: collision with root package name */
    public final byte[] f9406t;

    /* renamed from: u, reason: collision with root package name */
    public final DatagramPacket f9407u;

    /* renamed from: v, reason: collision with root package name */
    public Uri f9408v;

    /* renamed from: w, reason: collision with root package name */
    public DatagramSocket f9409w;

    /* renamed from: x, reason: collision with root package name */
    public MulticastSocket f9410x;

    /* renamed from: y, reason: collision with root package name */
    public InetAddress f9411y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f9412z;

    public g0() {
        super(true);
        this.f9405s = 8000;
        byte[] bArr = new byte[2000];
        this.f9406t = bArr;
        this.f9407u = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // o1.h
    public final void close() {
        this.f9408v = null;
        MulticastSocket multicastSocket = this.f9410x;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f9411y;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f9410x = null;
        }
        DatagramSocket datagramSocket = this.f9409w;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f9409w = null;
        }
        this.f9411y = null;
        this.A = 0;
        if (this.f9412z) {
            this.f9412z = false;
            q();
        }
    }

    @Override // o1.h
    public final long j(l lVar) {
        Uri uri = lVar.f9428a;
        this.f9408v = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.f9408v.getPort();
        r();
        try {
            this.f9411y = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f9411y, port);
            if (this.f9411y.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f9410x = multicastSocket;
                multicastSocket.joinGroup(this.f9411y);
                this.f9409w = this.f9410x;
            } else {
                this.f9409w = new DatagramSocket(inetSocketAddress);
            }
            this.f9409w.setSoTimeout(this.f9405s);
            this.f9412z = true;
            s(lVar);
            return -1L;
        } catch (IOException e7) {
            throw new f0(2001, e7);
        } catch (SecurityException e8) {
            throw new f0(2006, e8);
        }
    }

    @Override // o1.h
    public final Uri l() {
        return this.f9408v;
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.A;
        DatagramPacket datagramPacket = this.f9407u;
        if (i12 == 0) {
            try {
                DatagramSocket datagramSocket = this.f9409w;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.A = length;
                f(length);
            } catch (SocketTimeoutException e7) {
                throw new f0(2002, e7);
            } catch (IOException e8) {
                throw new f0(2001, e8);
            }
        }
        int length2 = datagramPacket.getLength();
        int i13 = this.A;
        int min = Math.min(i13, i11);
        System.arraycopy(this.f9406t, length2 - i13, bArr, i10, min);
        this.A -= min;
        return min;
    }
}
