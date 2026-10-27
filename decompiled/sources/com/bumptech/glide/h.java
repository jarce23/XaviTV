package com.bumptech.glide;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3017a;

    public h(int i10) {
        switch (i10) {
            case 1:
                this.f3017a = new HashMap();
                break;
            case 2:
                this.f3017a = new HashMap();
                new HashMap();
                break;
            case 3:
                this.f3017a = new HashMap();
                break;
            default:
                this.f3017a = new HashMap();
                break;
        }
    }

    public void a(HashMap hashMap) {
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap hashMap2 = this.f3017a;
            if (value == null) {
                hashMap2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    hashMap2.put(str, value);
                } else {
                    int i10 = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = o4.f.f9496b;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i10 < zArr.length) {
                            boolArr[i10] = Boolean.valueOf(zArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        String str3 = o4.f.f9496b;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i10 < bArr.length) {
                            bArr2[i10] = Byte.valueOf(bArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        String str4 = o4.f.f9496b;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i10 < iArr.length) {
                            numArr[i10] = Integer.valueOf(iArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        String str5 = o4.f.f9496b;
                        Long[] lArr = new Long[jArr.length];
                        while (i10 < jArr.length) {
                            lArr[i10] = Long.valueOf(jArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        String str6 = o4.f.f9496b;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i10 < fArr.length) {
                            fArr2[i10] = Float.valueOf(fArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                        }
                        double[] dArr = (double[]) value;
                        String str7 = o4.f.f9496b;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i10 < dArr.length) {
                            dArr2[i10] = Double.valueOf(dArr[i10]);
                            i10++;
                        }
                        hashMap2.put(str, dArr2);
                    }
                }
            }
        }
    }
}
