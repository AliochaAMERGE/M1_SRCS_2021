/**
 * Copyright 2005-2020 Talend
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * https://restlet.talend.com/
 * 
 * Restlet is a registered trademark of Talend S.A.
 */

package org.restlet.ext.nio.internal.channel;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import org.restlet.engine.io.ReadableSelectionChannel;
import org.restlet.engine.io.SelectionChannel;

/**
 * Trace byte channel that sends a copy of all data on the trace output stream.
 * It is important to implement {@link SelectionChannel} as some framework
 * classes rely on this down the processing chain.
 * 
 * @author Jerome Louvel
 * @deprecated Will be removed to favor lower-level network extensions allowing more control at the Restlet API level.
 */
@Deprecated
public class ReadableTraceChannel extends
        TraceChannel<ReadableSelectionChannel> implements
        ReadableSelectionChannel {

    /**
     * Constructor.
     * 
     * @param wrappedChannel
     *            The wrapped channel.
     */
    public ReadableTraceChannel(ReadableSelectionChannel wrappedChannel) {
        super(wrappedChannel);
    }

    /**
     * Constructor.
     * 
     * @param wrappedChannel
     *            The wrapped channel.
     * @param traceStream
     *            The trace stream.
     */
    public ReadableTraceChannel(ReadableSelectionChannel wrappedChannel,
            OutputStream traceStream) {
        super(wrappedChannel, traceStream);
    }

    /**
     * Reads the available byte from the wrapped channel to the destination
     * buffer while writing them to the console.
     * 
     * @param dst
     *            The destination buffer.
     * @return The number of bytes read.
     */
    public int read(ByteBuffer dst) throws IOException {
        int off = dst.arrayOffset() + dst.position();
        int oldPos = dst.position();
        int result = getWrappedChannel().read(dst);
        int newPos = dst.position();

        // We can't rely on the result variable because during SSL handshake,
        // bytes mights be read by never put into the destination buffer
        if (newPos > oldPos) {
            System.out.write(dst.array(), off, newPos - oldPos);
        }

        return result;
    }

}
