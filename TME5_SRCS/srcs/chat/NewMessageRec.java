// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package srcs.chat;

/**
 * Protobuf type {@code srcs.chat.NewMessageRec}
 */
public  final class NewMessageRec extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:srcs.chat.NewMessageRec)
    NewMessageRecOrBuilder {
private static final long serialVersionUID = 0L;
  // Use NewMessageRec.newBuilder() to construct.
  private NewMessageRec(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private NewMessageRec() {
    pseudoExpediteur_ = "";
    contenu_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private NewMessageRec(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            pseudoExpediteur_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            contenu_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return srcs.chat.ChatOuterClass.internal_static_srcs_chat_NewMessageRec_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return srcs.chat.ChatOuterClass.internal_static_srcs_chat_NewMessageRec_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            srcs.chat.NewMessageRec.class, srcs.chat.NewMessageRec.Builder.class);
  }

  public static final int PSEUDO_EXPEDITEUR_FIELD_NUMBER = 1;
  private volatile java.lang.Object pseudoExpediteur_;
  /**
   * <code>string pseudo_expediteur = 1;</code>
   */
  public java.lang.String getPseudoExpediteur() {
    java.lang.Object ref = pseudoExpediteur_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      pseudoExpediteur_ = s;
      return s;
    }
  }
  /**
   * <code>string pseudo_expediteur = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPseudoExpediteurBytes() {
    java.lang.Object ref = pseudoExpediteur_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      pseudoExpediteur_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTENU_FIELD_NUMBER = 2;
  private volatile java.lang.Object contenu_;
  /**
   * <code>string contenu = 2;</code>
   */
  public java.lang.String getContenu() {
    java.lang.Object ref = contenu_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      contenu_ = s;
      return s;
    }
  }
  /**
   * <code>string contenu = 2;</code>
   */
  public com.google.protobuf.ByteString
      getContenuBytes() {
    java.lang.Object ref = contenu_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      contenu_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPseudoExpediteurBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, pseudoExpediteur_);
    }
    if (!getContenuBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, contenu_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPseudoExpediteurBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, pseudoExpediteur_);
    }
    if (!getContenuBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, contenu_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof srcs.chat.NewMessageRec)) {
      return super.equals(obj);
    }
    srcs.chat.NewMessageRec other = (srcs.chat.NewMessageRec) obj;

    boolean result = true;
    result = result && getPseudoExpediteur()
        .equals(other.getPseudoExpediteur());
    result = result && getContenu()
        .equals(other.getContenu());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PSEUDO_EXPEDITEUR_FIELD_NUMBER;
    hash = (53 * hash) + getPseudoExpediteur().hashCode();
    hash = (37 * hash) + CONTENU_FIELD_NUMBER;
    hash = (53 * hash) + getContenu().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static srcs.chat.NewMessageRec parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static srcs.chat.NewMessageRec parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static srcs.chat.NewMessageRec parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static srcs.chat.NewMessageRec parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static srcs.chat.NewMessageRec parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static srcs.chat.NewMessageRec parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(srcs.chat.NewMessageRec prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code srcs.chat.NewMessageRec}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:srcs.chat.NewMessageRec)
      srcs.chat.NewMessageRecOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return srcs.chat.ChatOuterClass.internal_static_srcs_chat_NewMessageRec_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return srcs.chat.ChatOuterClass.internal_static_srcs_chat_NewMessageRec_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              srcs.chat.NewMessageRec.class, srcs.chat.NewMessageRec.Builder.class);
    }

    // Construct using srcs.chat.NewMessageRec.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pseudoExpediteur_ = "";

      contenu_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return srcs.chat.ChatOuterClass.internal_static_srcs_chat_NewMessageRec_descriptor;
    }

    @java.lang.Override
    public srcs.chat.NewMessageRec getDefaultInstanceForType() {
      return srcs.chat.NewMessageRec.getDefaultInstance();
    }

    @java.lang.Override
    public srcs.chat.NewMessageRec build() {
      srcs.chat.NewMessageRec result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public srcs.chat.NewMessageRec buildPartial() {
      srcs.chat.NewMessageRec result = new srcs.chat.NewMessageRec(this);
      result.pseudoExpediteur_ = pseudoExpediteur_;
      result.contenu_ = contenu_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof srcs.chat.NewMessageRec) {
        return mergeFrom((srcs.chat.NewMessageRec)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(srcs.chat.NewMessageRec other) {
      if (other == srcs.chat.NewMessageRec.getDefaultInstance()) return this;
      if (!other.getPseudoExpediteur().isEmpty()) {
        pseudoExpediteur_ = other.pseudoExpediteur_;
        onChanged();
      }
      if (!other.getContenu().isEmpty()) {
        contenu_ = other.contenu_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      srcs.chat.NewMessageRec parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (srcs.chat.NewMessageRec) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object pseudoExpediteur_ = "";
    /**
     * <code>string pseudo_expediteur = 1;</code>
     */
    public java.lang.String getPseudoExpediteur() {
      java.lang.Object ref = pseudoExpediteur_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pseudoExpediteur_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string pseudo_expediteur = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPseudoExpediteurBytes() {
      java.lang.Object ref = pseudoExpediteur_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pseudoExpediteur_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string pseudo_expediteur = 1;</code>
     */
    public Builder setPseudoExpediteur(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      pseudoExpediteur_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string pseudo_expediteur = 1;</code>
     */
    public Builder clearPseudoExpediteur() {
      
      pseudoExpediteur_ = getDefaultInstance().getPseudoExpediteur();
      onChanged();
      return this;
    }
    /**
     * <code>string pseudo_expediteur = 1;</code>
     */
    public Builder setPseudoExpediteurBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      pseudoExpediteur_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object contenu_ = "";
    /**
     * <code>string contenu = 2;</code>
     */
    public java.lang.String getContenu() {
      java.lang.Object ref = contenu_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        contenu_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string contenu = 2;</code>
     */
    public com.google.protobuf.ByteString
        getContenuBytes() {
      java.lang.Object ref = contenu_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        contenu_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string contenu = 2;</code>
     */
    public Builder setContenu(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      contenu_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string contenu = 2;</code>
     */
    public Builder clearContenu() {
      
      contenu_ = getDefaultInstance().getContenu();
      onChanged();
      return this;
    }
    /**
     * <code>string contenu = 2;</code>
     */
    public Builder setContenuBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      contenu_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:srcs.chat.NewMessageRec)
  }

  // @@protoc_insertion_point(class_scope:srcs.chat.NewMessageRec)
  private static final srcs.chat.NewMessageRec DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new srcs.chat.NewMessageRec();
  }

  public static srcs.chat.NewMessageRec getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewMessageRec>
      PARSER = new com.google.protobuf.AbstractParser<NewMessageRec>() {
    @java.lang.Override
    public NewMessageRec parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new NewMessageRec(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<NewMessageRec> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NewMessageRec> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public srcs.chat.NewMessageRec getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

