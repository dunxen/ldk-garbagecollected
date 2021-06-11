package org.ldk.structs;

import org.ldk.impl.bindings;
import org.ldk.enums.*;
import org.ldk.util.*;
import java.util.Arrays;


/**
 * An update generated by the underlying Channel itself which contains some new information the
 * ChannelMonitor should be made aware of.
 */
@SuppressWarnings("unchecked") // We correctly assign various generic arrays
public class ChannelMonitorUpdate extends CommonBase {
	ChannelMonitorUpdate(Object _dummy, long ptr) { super(ptr); }
	@Override @SuppressWarnings("deprecation")
	protected void finalize() throws Throwable {
		super.finalize();
		if (ptr != 0) { bindings.ChannelMonitorUpdate_free(ptr); }
	}

	/**
	 * The sequence number of this update. Updates *must* be replayed in-order according to this
	 * sequence number (and updates may panic if they are not). The update_id values are strictly
	 * increasing and increase by one for each new update, with one exception specified below.
	 * 
	 * This sequence number is also used to track up to which points updates which returned
	 * ChannelMonitorUpdateErr::TemporaryFailure have been applied to all copies of a given
	 * ChannelMonitor when ChannelManager::channel_monitor_updated is called.
	 * 
	 * The only instance where update_id values are not strictly increasing is the case where we
	 * allow post-force-close updates with a special update ID of [`CLOSED_CHANNEL_UPDATE_ID`]. See
	 * its docs for more details.
	 */
	public long get_update_id() {
		long ret = bindings.ChannelMonitorUpdate_get_update_id(this.ptr);
		return ret;
	}

	/**
	 * The sequence number of this update. Updates *must* be replayed in-order according to this
	 * sequence number (and updates may panic if they are not). The update_id values are strictly
	 * increasing and increase by one for each new update, with one exception specified below.
	 * 
	 * This sequence number is also used to track up to which points updates which returned
	 * ChannelMonitorUpdateErr::TemporaryFailure have been applied to all copies of a given
	 * ChannelMonitor when ChannelManager::channel_monitor_updated is called.
	 * 
	 * The only instance where update_id values are not strictly increasing is the case where we
	 * allow post-force-close updates with a special update ID of [`CLOSED_CHANNEL_UPDATE_ID`]. See
	 * its docs for more details.
	 */
	public void set_update_id(long val) {
		bindings.ChannelMonitorUpdate_set_update_id(this.ptr, val);
	}

	/**
	 * Creates a copy of the ChannelMonitorUpdate
	 */
	public ChannelMonitorUpdate clone() {
		long ret = bindings.ChannelMonitorUpdate_clone(this.ptr);
		ChannelMonitorUpdate ret_hu_conv = new ChannelMonitorUpdate(null, ret);
		ret_hu_conv.ptrs_to.add(this);
		return ret_hu_conv;
	}

	/**
	 * Serialize the ChannelMonitorUpdate object into a byte array which can be read by ChannelMonitorUpdate_read
	 */
	public byte[] write() {
		byte[] ret = bindings.ChannelMonitorUpdate_write(this.ptr);
		return ret;
	}

	/**
	 * Read a ChannelMonitorUpdate from a byte array, created by ChannelMonitorUpdate_write
	 */
	public static Result_ChannelMonitorUpdateDecodeErrorZ read(byte[] ser) {
		long ret = bindings.ChannelMonitorUpdate_read(ser);
		Result_ChannelMonitorUpdateDecodeErrorZ ret_hu_conv = Result_ChannelMonitorUpdateDecodeErrorZ.constr_from_ptr(ret);
		return ret_hu_conv;
	}

}
