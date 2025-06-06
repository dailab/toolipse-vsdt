package de.dailab.vsdt.diagram.parsers;

import java.util.Arrays;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.osgi.util.NLS;

import de.dailab.vsdt.diagram.part.Messages;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractParser implements IParser {

	/**
	 * @generated
	 */
	protected final EAttribute[] features;

	/**
	 * @generated
	 */
	private String viewPattern;

	/**
	 * @generated
	 */
	private String editorPattern;

	/**
	 * @generated
	 */
	private String editPattern;

	/**
	 * @generated
	 */
	public AbstractParser(EAttribute[] features) {
		if (features == null || Arrays.asList(features).contains(null)) {
			throw new IllegalArgumentException();
		}
		this.features = features;
	}

	/**
	 * @generated
	 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
	}

	/**
	 * @generated
	 */
	public String getEditorPattern() {
		return editorPattern;
	}

	/**
	 * @generated
	 */
	public void setEditorPattern(String editorPattern) {
		this.editorPattern = editorPattern;
	}

	/**
	 * @generated
	 */
	public String getEditPattern() {
		return editPattern;
	}

	/**
	 * @generated
	 */
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			return isAffectingFeature(((Notification) event).getFeature());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isAffectingFeature(Object feature) {
		for (int i = 0; i < features.length; i++) {
			if (features[i] == feature) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Object[] getValues(EObject element) {
		Object[] values = new Object[features.length];
		for (int i = 0; i < features.length; i++) {
			values[i] = getValue(element, features[i]);
		}
		return values;
	}

	/**
	 * @generated
	 */
	protected Object getValue(EObject element, EAttribute feature) {
		Object value = element.eGet(feature);
		Class iClass = feature.getEAttributeType().getInstanceClass();
		if (String.class.equals(iClass)) {
			if (value == null) {
				value = ""; //$NON-NLS-1$
			}
		}
		return value;
	}

	/**
	 * @generated
	 */
	protected ICommand getParseCommand(IAdaptable adapter, Object[] values,
			int flags) {
		if (values == null
				|| validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(element);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(
				editingDomain, "Set Values"); //$NON-NLS-1$
		for (int i = 0; i < values.length; i++) {
			command.compose(getModificationCommand(element, features[i],
					values[i]));
		}
		return command;
	}

	/**
	 * @generated
	 */
	protected ICommand getModificationCommand(EObject element,
			EAttribute feature, Object value) {
		value = getValidNewValue(feature, value);
		if (value instanceof InvalidValue) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		if (values.length != features.length) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		}
		for (int i = 0; i < values.length; i++) {
			Object value = getValidNewValue(features[i], values[i]);
			if (value instanceof InvalidValue) {
				return new ParserEditStatus(VsdtDiagramEditorPlugin.ID,
						IParserEditStatus.UNEDITABLE, value.toString());
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	protected Object getValidNewValue(EAttribute feature, Object value) {
		EClassifier type = feature.getEType();
		if (type instanceof EDataType) {
			Class iClass = type.getInstanceClass();
			if (Boolean.TYPE.equals(iClass)) {
				if (value instanceof Boolean) {
					// ok
				} else if (value instanceof String) {
					value = Boolean.valueOf((String) value);
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Character.TYPE.equals(iClass)) {
				if (value instanceof Character) {
					// ok
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						value = Character.valueOf(s.charAt(0));
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Byte.TYPE.equals(iClass)) {
				if (value instanceof Byte) {
					// ok
				} else if (value instanceof Number) {
					value = Byte.valueOf(((Number) value).byteValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Byte.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Short.TYPE.equals(iClass)) {
				if (value instanceof Short) {
					// ok
				} else if (value instanceof Number) {
					value = Short.valueOf(((Number) value).shortValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Short.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Integer.TYPE.equals(iClass)) {
				if (value instanceof Integer) {
					// ok
				} else if (value instanceof Number) {
					value = Integer.valueOf(((Number) value).intValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Integer.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Long.TYPE.equals(iClass)) {
				if (value instanceof Long) {
					// ok
				} else if (value instanceof Number) {
					value = Long.valueOf(((Number) value).longValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Long.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Float.TYPE.equals(iClass)) {
				if (value instanceof Float) {
					// ok
				} else if (value instanceof Number) {
					value = Float.valueOf(((Number) value).floatValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Float.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (Double.TYPE.equals(iClass)) {
				if (value instanceof Double) {
					// ok
				} else if (value instanceof Number) {
					value = Double.valueOf(((Number) value).doubleValue());
				} else if (value instanceof String) {
					String s = (String) value;
					if (s.length() == 0) {
						value = null;
					} else {
						try {
							value = Double.valueOf(s);
						} catch (NumberFormatException nfe) {
							value = new InvalidValue(
									NLS
											.bind(
													Messages.AbstractParser_WrongStringConversionMessage,
													iClass.getName()));
						}
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							iClass.getName()));
				}
			} else if (type instanceof EEnum) {
				if (value instanceof String) {
					EEnumLiteral literal = ((EEnum) type)
							.getEEnumLiteralByLiteral((String) value);
					if (literal == null) {
						value = new InvalidValue(NLS.bind(
								Messages.AbstractParser_UnknownLiteralMessage,
								value));
					} else {
						value = literal.getInstance();
					}
				} else {
					value = new InvalidValue(NLS.bind(
							Messages.AbstractParser_UnexpectedValueTypeMessage,
							String.class.getName()));
				}
			}
		}
		return value;
	}

	/**
	 * @generated
	 */
	protected class InvalidValue {

		/**
		 * @generated
		 */
		private String description;

		/**
		 * @generated
		 */
		public InvalidValue(String description) {
			this.description = description;
		}

		/**
		 * @generated
		 */
		public String toString() {
			return description;
		}
	}
}
