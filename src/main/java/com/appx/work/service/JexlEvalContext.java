package com.appx.work.service;

import java.math.MathContext;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.jexl3.JexlArithmetic;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.MapContext;

/**
 * A JEXL evaluation environment wrapping variables, namespace and options.
 */
public class JexlEvalContext implements JexlContext, JexlContext.NamespaceResolver, JexlEngine.Options {
	/** The marker for the empty vars. */
	private static final Map<String, Object> EMPTY_MAP = Collections.<String, Object> emptyMap();
	/** The variables. */
	private final JexlContext vars;
	/** The namespace. */
	private final JexlContext.NamespaceResolver ns;
	/** Whether the engine should be silent. */
	private Boolean silent = null;
	/** Whether the engine should be strict. */
	private Boolean strict = null;
	/** Whether the arithmetic should be strict. */
	private Boolean mathStrict = null;
	/** The math scale the arithmetic should use. */
	private int mathScale = Integer.MIN_VALUE;
	/** The math context the arithmetic should use. */
	private MathContext mathContext = null;

	/**
	 * Default constructor.
	 */
	public JexlEvalContext() {
		this(EMPTY_MAP);
	}

	@Override
	public Charset getCharset() {
		return Charset.defaultCharset();
	}

	/**
	 * Creates an evaluation environment wrapping an existing user provided
	 * vars.
	 * <p>
	 * The supplied vars should be null only in derived classes that override
	 * the get/set/has methods. For a default vars context with a code supplied
	 * vars, use the default no-parameter contructor.
	 * </p>
	 * 
	 * @param map
	 *            the variables map
	 */
	public JexlEvalContext(Map<String, Object> map) {
		this.vars = map == EMPTY_MAP ? new MapContext() : new MapContext(map);
		this.ns = null;
	}

	/**
	 * Creates an evaluation environment from a context.
	 * 
	 * @param context
	 *            the context (may be null, implies readonly)
	 */
	public JexlEvalContext(JexlContext context) {
		this(context,
				context instanceof JexlContext.NamespaceResolver ? (JexlContext.NamespaceResolver) context : null);
	}

	/**
	 * Creates an evaluation environment from a context and a namespace.
	 * 
	 * @param context
	 *            the context (may be null, implies readonly)
	 * @param namespace
	 *            the namespace (may be null, implies empty namespace)
	 */
	public JexlEvalContext(JexlContext context, JexlContext.NamespaceResolver namespace) {
		this.vars = context != null ? context : JexlEngine.EMPTY_CONTEXT;
		this.ns = namespace != null ? namespace : JexlEngine.EMPTY_NS;
	}

	@Override
	public boolean has(String name) {
		return vars.has(name);
	}

	@Override
	public Object get(String name) {
		return vars.get(name);
	}

	@Override
	public void set(String name, Object value) {
		vars.set(name, value);
	}

	@Override
	public Object resolveNamespace(String name) {
		return ns != null ? ns.resolveNamespace(name) : null;
	}

	/**
	 * Clear all options.
	 */
	public void clearOptions() {
		silent = null;
		strict = null;
		mathScale = -1;
		mathContext = null;
	}

	/**
	 * Sets whether the engine will throw JexlException during evaluation when
	 * an error is triggered.
	 * 
	 * @param s
	 *            true means no JexlException will occur, false allows them
	 */
	public void setSilent(boolean s) {
		this.silent = s ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean isSilent() {
		return this.silent;
	}

	/**
	 * Sets the engine and arithmetic strict flags in one call.
	 * 
	 * @param se
	 *            the engine strict flag
	 * @param sa
	 *            the arithmetic strict flag
	 */
	public void setStrict(boolean se, boolean sa) {
		this.strict = se ? Boolean.TRUE : Boolean.FALSE;
		this.mathStrict = sa ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Sets whether the engine will consider unknown variables, methods and
	 * constructors as errors or evaluates them as null.
	 * 
	 * @param se
	 *            true means strict error reporting, false allows mentioned
	 *            conditions to be evaluated as null
	 */
	public void setStrict(boolean se) {
		setStrict(se, se);
	}

	@Override
	public Boolean isStrict() {
		if (strict == null) {
			return null;
		} else {
			return strict.booleanValue() ? Boolean.TRUE : Boolean.FALSE;
		}
	}

	/**
	 * Sets whether the arithmetic will consider null arguments as errors during
	 * evaluation.
	 * 
	 * @param s
	 *            true means strict error reporting, false allows mentioned
	 *            conditions to be evaluated as 0
	 */
	public void setStrictArithmetic(boolean s) {
		this.mathStrict = s ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean isStrictArithmetic() {
		if (mathStrict == null) {
			return null;
		} else {
			return mathStrict.booleanValue() ? Boolean.TRUE : Boolean.FALSE;
		}
	}

	@Override
	public MathContext getArithmeticMathContext() {
		return mathContext;
	}

	/**
	 * Sets the {@link MathContext} to use by the {@link JexlArithmetic} during
	 * evaluation.
	 * 
	 * @param mc
	 *            the math context
	 */
	public void setMathContext(MathContext mc) {
		mathContext = mc;
	}

	@Override
	public int getArithmeticMathScale() {
		return mathScale;
	}

	/**
	 * Sets the math scale to use to use by the {@link JexlArithmetic} during
	 * evaluation.
	 * 
	 * @param scale
	 *            the math scale
	 */
	public void setMathScale(int scale) {
		mathScale = scale;
	}

}
