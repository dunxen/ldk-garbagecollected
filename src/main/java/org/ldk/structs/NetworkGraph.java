package org.ldk.structs;

import org.ldk.impl.bindings;
import org.ldk.enums.*;
import org.ldk.util.*;
import java.util.Arrays;
import java.lang.ref.Reference;
import javax.annotation.Nullable;


/**
 * Represents the network as nodes and channels between them
 */
@SuppressWarnings("unchecked") // We correctly assign various generic arrays
public class NetworkGraph extends CommonBase {
	NetworkGraph(Object _dummy, long ptr) { super(ptr); }
	@Override @SuppressWarnings("deprecation")
	protected void finalize() throws Throwable {
		super.finalize();
		if (ptr != 0) { bindings.NetworkGraph_free(ptr); }
	}

	/**
	 * Constructs a new EventHandler which calls the relevant methods on this_arg.
	 * This copies the `inner` pointer in this_arg and thus the returned EventHandler must be freed before this_arg is
	 */
	public EventHandler as_EventHandler() {
		long ret = bindings.NetworkGraph_as_EventHandler(this.ptr);
		Reference.reachabilityFence(this);
		if (ret >= 0 && ret <= 4096) { return null; }
		EventHandler ret_hu_conv = new EventHandler(null, ret);
		ret_hu_conv.ptrs_to.add(this);
		return ret_hu_conv;
	}

	/**
	 * Serialize the NetworkGraph object into a byte array which can be read by NetworkGraph_read
	 */
	public byte[] write() {
		byte[] ret = bindings.NetworkGraph_write(this.ptr);
		Reference.reachabilityFence(this);
		return ret;
	}

	/**
	 * Read a NetworkGraph from a byte array, created by NetworkGraph_write
	 */
	public static Result_NetworkGraphDecodeErrorZ read(byte[] ser, Logger arg) {
		long ret = bindings.NetworkGraph_read(ser, arg == null ? 0 : arg.ptr);
		Reference.reachabilityFence(ser);
		Reference.reachabilityFence(arg);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NetworkGraphDecodeErrorZ ret_hu_conv = Result_NetworkGraphDecodeErrorZ.constr_from_ptr(ret);
		ret_hu_conv.ptrs_to.add(arg);
		return ret_hu_conv;
	}

	/**
	 * Creates a new, empty, network graph.
	 */
	public static NetworkGraph of(byte[] genesis_hash, Logger logger) {
		long ret = bindings.NetworkGraph_new(InternalUtils.check_arr_len(genesis_hash, 32), logger == null ? 0 : logger.ptr);
		Reference.reachabilityFence(genesis_hash);
		Reference.reachabilityFence(logger);
		if (ret >= 0 && ret <= 4096) { return null; }
		org.ldk.structs.NetworkGraph ret_hu_conv = null; if (ret < 0 || ret > 4096) { ret_hu_conv = new org.ldk.structs.NetworkGraph(null, ret); }
		ret_hu_conv.ptrs_to.add(ret_hu_conv);
		ret_hu_conv.ptrs_to.add(logger);
		return ret_hu_conv;
	}

	/**
	 * Returns a read-only view of the network graph.
	 */
	public ReadOnlyNetworkGraph read_only() {
		long ret = bindings.NetworkGraph_read_only(this.ptr);
		Reference.reachabilityFence(this);
		if (ret >= 0 && ret <= 4096) { return null; }
		org.ldk.structs.ReadOnlyNetworkGraph ret_hu_conv = null; if (ret < 0 || ret > 4096) { ret_hu_conv = new org.ldk.structs.ReadOnlyNetworkGraph(null, ret); }
		ret_hu_conv.ptrs_to.add(this);
		return ret_hu_conv;
	}

	/**
	 * The unix timestamp provided by the most recent rapid gossip sync.
	 * It will be set by the rapid sync process after every sync completion.
	 */
	public Option_u32Z get_last_rapid_gossip_sync_timestamp() {
		long ret = bindings.NetworkGraph_get_last_rapid_gossip_sync_timestamp(this.ptr);
		Reference.reachabilityFence(this);
		if (ret >= 0 && ret <= 4096) { return null; }
		org.ldk.structs.Option_u32Z ret_hu_conv = org.ldk.structs.Option_u32Z.constr_from_ptr(ret);
		ret_hu_conv.ptrs_to.add(this);
		return ret_hu_conv;
	}

	/**
	 * Update the unix timestamp provided by the most recent rapid gossip sync.
	 * This should be done automatically by the rapid sync process after every sync completion.
	 */
	public void set_last_rapid_gossip_sync_timestamp(int last_rapid_gossip_sync_timestamp) {
		bindings.NetworkGraph_set_last_rapid_gossip_sync_timestamp(this.ptr, last_rapid_gossip_sync_timestamp);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(last_rapid_gossip_sync_timestamp);
	}

	/**
	 * For an already known node (from channel announcements), update its stored properties from a
	 * given node announcement.
	 * 
	 * You probably don't want to call this directly, instead relying on a P2PGossipSync's
	 * RoutingMessageHandler implementation to call it indirectly. This may be useful to accept
	 * routing messages from a source using a protocol other than the lightning P2P protocol.
	 */
	public Result_NoneLightningErrorZ update_node_from_announcement(NodeAnnouncement msg) {
		long ret = bindings.NetworkGraph_update_node_from_announcement(this.ptr, msg == null ? 0 : msg.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		return ret_hu_conv;
	}

	/**
	 * For an already known node (from channel announcements), update its stored properties from a
	 * given node announcement without verifying the associated signatures. Because we aren't
	 * given the associated signatures here we cannot relay the node announcement to any of our
	 * peers.
	 */
	public Result_NoneLightningErrorZ update_node_from_unsigned_announcement(UnsignedNodeAnnouncement msg) {
		long ret = bindings.NetworkGraph_update_node_from_unsigned_announcement(this.ptr, msg == null ? 0 : msg.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		return ret_hu_conv;
	}

	/**
	 * Store or update channel info from a channel announcement.
	 * 
	 * You probably don't want to call this directly, instead relying on a P2PGossipSync's
	 * RoutingMessageHandler implementation to call it indirectly. This may be useful to accept
	 * routing messages from a source using a protocol other than the lightning P2P protocol.
	 * 
	 * If a `chain::Access` object is provided via `chain_access`, it will be called to verify
	 * the corresponding UTXO exists on chain and is correctly-formatted.
	 */
	public Result_NoneLightningErrorZ update_channel_from_announcement(ChannelAnnouncement msg, Option_AccessZ chain_access) {
		long ret = bindings.NetworkGraph_update_channel_from_announcement(this.ptr, msg == null ? 0 : msg.ptr & ~1, chain_access.ptr);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		Reference.reachabilityFence(chain_access);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		this.ptrs_to.add(chain_access);
		return ret_hu_conv;
	}

	/**
	 * Store or update channel info from a channel announcement without verifying the associated
	 * signatures. Because we aren't given the associated signatures here we cannot relay the
	 * channel announcement to any of our peers.
	 * 
	 * If a `chain::Access` object is provided via `chain_access`, it will be called to verify
	 * the corresponding UTXO exists on chain and is correctly-formatted.
	 */
	public Result_NoneLightningErrorZ update_channel_from_unsigned_announcement(UnsignedChannelAnnouncement msg, Option_AccessZ chain_access) {
		long ret = bindings.NetworkGraph_update_channel_from_unsigned_announcement(this.ptr, msg == null ? 0 : msg.ptr & ~1, chain_access.ptr);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		Reference.reachabilityFence(chain_access);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		this.ptrs_to.add(chain_access);
		return ret_hu_conv;
	}

	/**
	 * Update channel from partial announcement data received via rapid gossip sync
	 * 
	 * `timestamp: u64`: Timestamp emulating the backdated original announcement receipt (by the
	 * rapid gossip sync server)
	 * 
	 * All other parameters as used in [`msgs::UnsignedChannelAnnouncement`] fields.
	 */
	public Result_NoneLightningErrorZ add_channel_from_partial_announcement(long short_channel_id, long timestamp, ChannelFeatures features, byte[] node_id_1, byte[] node_id_2) {
		long ret = bindings.NetworkGraph_add_channel_from_partial_announcement(this.ptr, short_channel_id, timestamp, features == null ? 0 : features.ptr & ~1, InternalUtils.check_arr_len(node_id_1, 33), InternalUtils.check_arr_len(node_id_2, 33));
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(short_channel_id);
		Reference.reachabilityFence(timestamp);
		Reference.reachabilityFence(features);
		Reference.reachabilityFence(node_id_1);
		Reference.reachabilityFence(node_id_2);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		return ret_hu_conv;
	}

	/**
	 * Marks a channel in the graph as failed if a corresponding HTLC fail was sent.
	 * If permanent, removes a channel from the local storage.
	 * May cause the removal of nodes too, if this was their last channel.
	 * If not permanent, makes channels unavailable for routing.
	 */
	public void channel_failed(long short_channel_id, boolean is_permanent) {
		bindings.NetworkGraph_channel_failed(this.ptr, short_channel_id, is_permanent);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(short_channel_id);
		Reference.reachabilityFence(is_permanent);
	}

	/**
	 * Marks a node in the graph as failed.
	 */
	public void node_failed(byte[] _node_id, boolean is_permanent) {
		bindings.NetworkGraph_node_failed(this.ptr, InternalUtils.check_arr_len(_node_id, 33), is_permanent);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(_node_id);
		Reference.reachabilityFence(is_permanent);
	}

	/**
	 * Removes information about channels that we haven't heard any updates about in some time.
	 * This can be used regularly to prune the network graph of channels that likely no longer
	 * exist.
	 * 
	 * While there is no formal requirement that nodes regularly re-broadcast their channel
	 * updates every two weeks, the non-normative section of BOLT 7 currently suggests that
	 * pruning occur for updates which are at least two weeks old, which we implement here.
	 * 
	 * Note that for users of the `lightning-background-processor` crate this method may be
	 * automatically called regularly for you.
	 * 
	 * This method is only available with the `std` feature. See
	 * [`NetworkGraph::remove_stale_channels_with_time`] for `no-std` use.
	 */
	public void remove_stale_channels() {
		bindings.NetworkGraph_remove_stale_channels(this.ptr);
		Reference.reachabilityFence(this);
	}

	/**
	 * Removes information about channels that we haven't heard any updates about in some time.
	 * This can be used regularly to prune the network graph of channels that likely no longer
	 * exist.
	 * 
	 * While there is no formal requirement that nodes regularly re-broadcast their channel
	 * updates every two weeks, the non-normative section of BOLT 7 currently suggests that
	 * pruning occur for updates which are at least two weeks old, which we implement here.
	 * 
	 * This function takes the current unix time as an argument. For users with the `std` feature
	 * enabled, [`NetworkGraph::remove_stale_channels`] may be preferable.
	 */
	public void remove_stale_channels_with_time(long current_time_unix) {
		bindings.NetworkGraph_remove_stale_channels_with_time(this.ptr, current_time_unix);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(current_time_unix);
	}

	/**
	 * For an already known (from announcement) channel, update info about one of the directions
	 * of the channel.
	 * 
	 * You probably don't want to call this directly, instead relying on a P2PGossipSync's
	 * RoutingMessageHandler implementation to call it indirectly. This may be useful to accept
	 * routing messages from a source using a protocol other than the lightning P2P protocol.
	 * 
	 * If built with `no-std`, any updates with a timestamp more than two weeks in the past or
	 * materially in the future will be rejected.
	 */
	public Result_NoneLightningErrorZ update_channel(ChannelUpdate msg) {
		long ret = bindings.NetworkGraph_update_channel(this.ptr, msg == null ? 0 : msg.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		return ret_hu_conv;
	}

	/**
	 * For an already known (from announcement) channel, update info about one of the directions
	 * of the channel without verifying the associated signatures. Because we aren't given the
	 * associated signatures here we cannot relay the channel update to any of our peers.
	 * 
	 * If built with `no-std`, any updates with a timestamp more than two weeks in the past or
	 * materially in the future will be rejected.
	 */
	public Result_NoneLightningErrorZ update_channel_unsigned(UnsignedChannelUpdate msg) {
		long ret = bindings.NetworkGraph_update_channel_unsigned(this.ptr, msg == null ? 0 : msg.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(msg);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_NoneLightningErrorZ ret_hu_conv = Result_NoneLightningErrorZ.constr_from_ptr(ret);
		this.ptrs_to.add(msg);
		return ret_hu_conv;
	}

}
