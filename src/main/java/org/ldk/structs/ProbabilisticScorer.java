package org.ldk.structs;

import org.ldk.impl.bindings;
import org.ldk.enums.*;
import org.ldk.util.*;
import java.util.Arrays;
import java.lang.ref.Reference;
import javax.annotation.Nullable;


/**
 * [`Score`] implementation using channel success probability distributions.
 * 
 * Based on *Optimally Reliable & Cheap Payment Flows on the Lightning Network* by Rene Pickhardt
 * and Stefan Richter [[1]]. Given the uncertainty of channel liquidity balances, probability
 * distributions are defined based on knowledge learned from successful and unsuccessful attempts.
 * Then the negative `log10` of the success probability is used to determine the cost of routing a
 * specific HTLC amount through a channel.
 * 
 * Knowledge about channel liquidity balances takes the form of upper and lower bounds on the
 * possible liquidity. Certainty of the bounds is decreased over time using a decay function. See
 * [`ProbabilisticScoringParameters`] for details.
 * 
 * Since the scorer aims to learn the current channel liquidity balances, it works best for nodes
 * with high payment volume or that actively probe the [`NetworkGraph`]. Nodes with low payment
 * volume are more likely to experience failed payment paths, which would need to be retried.
 * 
 * # Note
 * 
 * Mixing the `no-std` feature between serialization and deserialization results in undefined
 * behavior.
 * 
 * [1]: https://arxiv.org/abs/2107.05322
 */
@SuppressWarnings("unchecked") // We correctly assign various generic arrays
public class ProbabilisticScorer extends CommonBase {
	ProbabilisticScorer(Object _dummy, long ptr) { super(ptr); }
	@Override @SuppressWarnings("deprecation")
	protected void finalize() throws Throwable {
		super.finalize();
		if (ptr != 0) { bindings.ProbabilisticScorer_free(ptr); }
	}

	/**
	 * Creates a new scorer using the given scoring parameters for sending payments from a node
	 * through a network graph.
	 */
	public static ProbabilisticScorer of(ProbabilisticScoringParameters params, NetworkGraph network_graph, Logger logger) {
		long ret = bindings.ProbabilisticScorer_new(params == null ? 0 : params.ptr & ~1, network_graph == null ? 0 : network_graph.ptr & ~1, logger == null ? 0 : logger.ptr);
		Reference.reachabilityFence(params);
		Reference.reachabilityFence(network_graph);
		Reference.reachabilityFence(logger);
		if (ret >= 0 && ret <= 4096) { return null; }
		org.ldk.structs.ProbabilisticScorer ret_hu_conv = null; if (ret < 0 || ret > 4096) { ret_hu_conv = new org.ldk.structs.ProbabilisticScorer(null, ret); }
		ret_hu_conv.ptrs_to.add(ret_hu_conv);
		ret_hu_conv.ptrs_to.add(network_graph);
		ret_hu_conv.ptrs_to.add(logger);
		return ret_hu_conv;
	}

	/**
	 * Dump the contents of this scorer into the configured logger.
	 * 
	 * Note that this writes roughly one line per channel for which we have a liquidity estimate,
	 * which may be a substantial amount of log output.
	 */
	public void debug_log_liquidity_stats() {
		bindings.ProbabilisticScorer_debug_log_liquidity_stats(this.ptr);
		Reference.reachabilityFence(this);
	}

	/**
	 * Query the estimated minimum and maximum liquidity available for sending a payment over the
	 * channel with `scid` towards the given `target` node.
	 */
	public Option_C2Tuple_u64u64ZZ estimated_channel_liquidity_range(long scid, NodeId target) {
		long ret = bindings.ProbabilisticScorer_estimated_channel_liquidity_range(this.ptr, scid, target == null ? 0 : target.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(scid);
		Reference.reachabilityFence(target);
		if (ret >= 0 && ret <= 4096) { return null; }
		org.ldk.structs.Option_C2Tuple_u64u64ZZ ret_hu_conv = org.ldk.structs.Option_C2Tuple_u64u64ZZ.constr_from_ptr(ret);
		ret_hu_conv.ptrs_to.add(this);
		this.ptrs_to.add(target);
		return ret_hu_conv;
	}

	/**
	 * Marks the node with the given `node_id` as banned, i.e.,
	 * it will be avoided during path finding.
	 */
	public void add_banned(NodeId node_id) {
		bindings.ProbabilisticScorer_add_banned(this.ptr, node_id == null ? 0 : node_id.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(node_id);
		this.ptrs_to.add(node_id);
	}

	/**
	 * Removes the node with the given `node_id` from the list of nodes to avoid.
	 */
	public void remove_banned(NodeId node_id) {
		bindings.ProbabilisticScorer_remove_banned(this.ptr, node_id == null ? 0 : node_id.ptr & ~1);
		Reference.reachabilityFence(this);
		Reference.reachabilityFence(node_id);
		this.ptrs_to.add(node_id);
	}

	/**
	 * Clears the list of nodes that are avoided during path finding.
	 */
	public void clear_banned() {
		bindings.ProbabilisticScorer_clear_banned(this.ptr);
		Reference.reachabilityFence(this);
	}

	/**
	 * Constructs a new Score which calls the relevant methods on this_arg.
	 * This copies the `inner` pointer in this_arg and thus the returned Score must be freed before this_arg is
	 */
	public Score as_Score() {
		long ret = bindings.ProbabilisticScorer_as_Score(this.ptr);
		Reference.reachabilityFence(this);
		if (ret >= 0 && ret <= 4096) { return null; }
		Score ret_hu_conv = new Score(null, ret);
		ret_hu_conv.ptrs_to.add(this);
		return ret_hu_conv;
	}

	/**
	 * Serialize the ProbabilisticScorer object into a byte array which can be read by ProbabilisticScorer_read
	 */
	public byte[] write() {
		byte[] ret = bindings.ProbabilisticScorer_write(this.ptr);
		Reference.reachabilityFence(this);
		return ret;
	}

	/**
	 * Read a ProbabilisticScorer from a byte array, created by ProbabilisticScorer_write
	 */
	public static Result_ProbabilisticScorerDecodeErrorZ read(byte[] ser, ProbabilisticScoringParameters arg_a, NetworkGraph arg_b, Logger arg_c) {
		long ret = bindings.ProbabilisticScorer_read(ser, arg_a == null ? 0 : arg_a.ptr & ~1, arg_b == null ? 0 : arg_b.ptr & ~1, arg_c == null ? 0 : arg_c.ptr);
		Reference.reachabilityFence(ser);
		Reference.reachabilityFence(arg_a);
		Reference.reachabilityFence(arg_b);
		Reference.reachabilityFence(arg_c);
		if (ret >= 0 && ret <= 4096) { return null; }
		Result_ProbabilisticScorerDecodeErrorZ ret_hu_conv = Result_ProbabilisticScorerDecodeErrorZ.constr_from_ptr(ret);
		ret_hu_conv.ptrs_to.add(arg_b);
		ret_hu_conv.ptrs_to.add(arg_c);
		return ret_hu_conv;
	}

}
