package rb;

import j9.v1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g0 extends e0 {
    public static s c(Path path) {
        i0 i0Var;
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path readSymbolicLink = readAttributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            if (readSymbolicLink != null) {
                String str = i0.f11020p;
                i0Var = v1.w(readSymbolicLink);
            } else {
                i0Var = null;
            }
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            Long n10 = creationTime != null ? n(creationTime) : null;
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            Long n11 = lastModifiedTime != null ? n(lastModifiedTime) : null;
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            return new s(isRegularFile, isDirectory, i0Var, valueOf, n10, n11, lastAccessTime != null ? n(lastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public static Long n(FileTime fileTime) {
        long millis;
        millis = fileTime.toMillis();
        Long valueOf = Long.valueOf(millis);
        if (millis != 0) {
            return valueOf;
        }
        return null;
    }

    @Override // rb.e0, rb.u
    public void atomicMove(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        try {
            Files.move(i0Var.f(), i0Var2.f(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e7) {
            throw new FileNotFoundException(e7.getMessage());
        }
    }

    @Override // rb.e0, rb.u
    public void createSymlink(i0 i0Var, i0 i0Var2) {
        za.h.e("source", i0Var);
        za.h.e("target", i0Var2);
        Files.createSymbolicLink(i0Var.f(), i0Var2.f(), new FileAttribute[0]);
    }

    @Override // rb.e0, rb.u
    public s metadataOrNull(i0 i0Var) {
        za.h.e("path", i0Var);
        return c(i0Var.f());
    }

    @Override // rb.e0
    public String toString() {
        return "NioSystemFileSystem";
    }
}
