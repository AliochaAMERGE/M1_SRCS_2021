// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package srcs.chat;

public final class ChatOuterClass {
  private ChatOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_srcs_chat_SubscribeChat_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_srcs_chat_SubscribeChat_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_srcs_chat_SendChat_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_srcs_chat_SendChat_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_srcs_chat_NewMessageRec_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_srcs_chat_NewMessageRec_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nchat.proto\022\tsrcs.chat\032\036google/protobuf" +
      "/wrappers.proto\032\033google/protobuf/empty.p" +
      "roto\";\n\rSubscribeChat\022\016\n\006pseudo\030\001 \001(\t\022\014\n" +
      "\004host\030\002 \001(\t\022\014\n\004port\030\003 \001(\021\"+\n\010SendChat\022\016\n" +
      "\006pseudo\030\001 \001(\t\022\017\n\007message\030\002 \001(\t\";\n\rNewMes" +
      "sageRec\022\031\n\021pseudo_expediteur\030\001 \001(\t\022\017\n\007co" +
      "ntenu\030\002 \001(\t2\217\002\n\004Chat\022A\n\tsubscribe\022\030.srcs" +
      ".chat.SubscribeChat\032\032.google.protobuf.Bo" +
      "olValue\0228\n\004send\022\023.srcs.chat.SendChat\032\033.g" +
      "oogle.protobuf.Int32Value\022E\n\013listChatter" +
      "\022\026.google.protobuf.Empty\032\034.google.protob" +
      "uf.StringValue0\001\022C\n\013unsubscribe\022\034.google" +
      ".protobuf.StringValue\032\026.google.protobuf." +
      "Empty2Q\n\017MessageReceiver\022>\n\nnewMessage\022\030" +
      ".srcs.chat.NewMessageRec\032\026.google.protob" +
      "uf.EmptyB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_srcs_chat_SubscribeChat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_srcs_chat_SubscribeChat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_srcs_chat_SubscribeChat_descriptor,
        new java.lang.String[] { "Pseudo", "Host", "Port", });
    internal_static_srcs_chat_SendChat_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_srcs_chat_SendChat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_srcs_chat_SendChat_descriptor,
        new java.lang.String[] { "Pseudo", "Message", });
    internal_static_srcs_chat_NewMessageRec_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_srcs_chat_NewMessageRec_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_srcs_chat_NewMessageRec_descriptor,
        new java.lang.String[] { "PseudoExpediteur", "Contenu", });
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
