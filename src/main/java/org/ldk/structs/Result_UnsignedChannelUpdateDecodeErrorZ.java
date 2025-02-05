package org.ldk.structs;

import org.ldk.impl.bindings;
import org.ldk.enums.*;
import org.ldk.util.*;
import java.util.Arrays;
import java.lang.ref.Reference;
import javax.annotation.Nullable;

public class Result_UnsignedChannelUpdateDecodeErrorZ extends CommonBase {
	private Result_UnsignedChannelUpdateDecodeErrorZ(Object _dummy, long ptr) { super(ptr); }
	protected void finalize() throws Throwable {
		if (ptr != 0) { bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_free(ptr); } super.finalize();
	}

	static Result_UnsignedChannelUpdateDecodeErrorZ constr_from_ptr(long ptr) {
		if (bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_is_ok(ptr)) {
			return new Result_UnsignedChannelUpdateDecodeErrorZ_OK(null, ptr);
		} else {
			return new Result_UnsignedChannelUpdateDecodeErrorZ_Err(null, ptr);
		}
	}
	public static final class Result_UnsignedChannelUpdateDecodeErrorZ_OK extends Result_UnsignedChannelUpdateDecodeErrorZ {
		public final UnsignedChannelUpdate res;
		private Result_UnsignedChannelUpdateDecodeErrorZ_OK(Object _dummy, long ptr) {
			super(_dummy, ptr);
			long res = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_get_ok(ptr);
			org.ldk.structs.UnsignedChannelUpdate res_hu_conv = null; if (res < 0 || res > 4096) { res_hu_conv = new org.ldk.structs.UnsignedChannelUpdate(null, res); }
			res_hu_conv.ptrs_to.add(this);
			this.res = res_hu_conv;
		}
	}

	public static final class Result_UnsignedChannelUpdateDecodeErrorZ_Err extends Result_UnsignedChannelUpdateDecodeErrorZ {
		public final DecodeError err;
		private Result_UnsignedChannelUpdateDecodeErrorZ_Err(Object _dummy, long ptr) {
			super(_dummy, ptr);
			long err = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_get_err(ptr);
			org.ldk.structs.DecodeError err_hu_conv = null; if (err < 0 || err > 4096) { err_hu_conv = new org.ldk.structs.DecodeError(null, err); }
			err_hu_conv.ptrs_to.add(this);
			this.err = err_hu_conv;
		}
	}

	/**
	 * Creates a new CResult_UnsignedChannelUpdateDecodeErrorZ in the success state.
	 */
	public static Result_UnsignedChannelUpdateDecodeErrorZ ok(UnsignedChannelUpdate o) {
		long ret = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_ok(o == null ? 0 : o.ptr & ~1);
		Reference.reachabilityFence(o);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_UnsignedChannelUpdateDecodeErrorZ ret_hu_conv = Result_UnsignedChannelUpdateDecodeErrorZ.constr_from_ptr(ret);
		return ret_hu_conv;
	}

	/**
	 * Creates a new CResult_UnsignedChannelUpdateDecodeErrorZ in the error state.
	 */
	public static Result_UnsignedChannelUpdateDecodeErrorZ err(DecodeError e) {
		long ret = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_err(e == null ? 0 : e.ptr & ~1);
		Reference.reachabilityFence(e);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_UnsignedChannelUpdateDecodeErrorZ ret_hu_conv = Result_UnsignedChannelUpdateDecodeErrorZ.constr_from_ptr(ret);
		return ret_hu_conv;
	}

	/**
	 * Checks if the given object is currently in the success state
	 */
	public boolean is_ok() {
		boolean ret = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_is_ok(this.ptr);
		Reference.reachabilityFence(this);
		return ret;
	}

	long clone_ptr() {
		long ret = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_clone_ptr(this.ptr);
		Reference.reachabilityFence(this);
		return ret;
	}

	/**
	 * Creates a new CResult_UnsignedChannelUpdateDecodeErrorZ which has the same data as `orig`
	 * but with all dynamically-allocated buffers duplicated in new buffers.
	 */
	public Result_UnsignedChannelUpdateDecodeErrorZ clone() {
		long ret = bindings.CResult_UnsignedChannelUpdateDecodeErrorZ_clone(this.ptr);
		Reference.reachabilityFence(this);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_UnsignedChannelUpdateDecodeErrorZ ret_hu_conv = Result_UnsignedChannelUpdateDecodeErrorZ.constr_from_ptr(ret);
		return ret_hu_conv;
	}

}
