// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mapRem.proto

package srcs.map;

public interface EntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:srcs.map.Entry)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Any key = 1;</code>
   * @return Whether the key field is set.
   */
  boolean hasKey();
  /**
   * <code>.google.protobuf.Any key = 1;</code>
   * @return The key.
   */
  com.google.protobuf.Any getKey();
  /**
   * <code>.google.protobuf.Any key = 1;</code>
   */
  com.google.protobuf.AnyOrBuilder getKeyOrBuilder();

  /**
   * <code>.google.protobuf.Any value = 2;</code>
   * @return Whether the value field is set.
   */
  boolean hasValue();
  /**
   * <code>.google.protobuf.Any value = 2;</code>
   * @return The value.
   */
  com.google.protobuf.Any getValue();
  /**
   * <code>.google.protobuf.Any value = 2;</code>
   */
  com.google.protobuf.AnyOrBuilder getValueOrBuilder();
}
