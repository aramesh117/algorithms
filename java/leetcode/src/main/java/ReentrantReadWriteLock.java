import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantReadWriteLock {
    private final Lock lock = new ReentrantLock();
    private final Condition mNoWriters = lock.newCondition();
    private final Condition mNoReaders = lock.newCondition();

    private int mNumWriters = 0;
    private int mNumReaders = 0;

    public void readLock() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (mNumWriters > 0) {
                mNoWriters.await();
            }
            mNumReaders++;
        } finally {
            lock.unlock();
        }
    }

    public void readUnlock() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (mNumReaders > 0) {
                mNumReaders--;
            } else {
                throw new IllegalStateException("Must call readLock before calling readUnlock.");
            }
            if (mNumReaders == 0) {
                mNoReaders.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void writeLock() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (mNumReaders > 0) {
                mNoReaders.await();
            }
            mNumWriters++;
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (mNumWriters > 0) {
                mNumWriters--;
            } else {
                throw new IllegalStateException("Must call writeLock before calling writeUnlock.");
            }
            mNoWriters.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
