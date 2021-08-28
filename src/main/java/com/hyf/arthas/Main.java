package com.hyf.arthas;

import com.sun.tools.attach.VirtualMachine;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.InputStream;

/**
 * @author baB_hyf
 * @date 2021/08/06
 */
public class Main {
    
    public static void main(String[] args)throws Exception {
        VirtualMachine virtualMachine = VirtualMachine.attach("14716");
        HotSpotVirtualMachine hotSpotVirtualMachine = (HotSpotVirtualMachine)virtualMachine;
        // threaddump
        InputStream inputStream = hotSpotVirtualMachine.remoteDataDump(new String[]{});
        
        byte[] buff = new byte[256];
        int len;
        do {
            len = inputStream.read(buff);
            if (len > 0) {
                String respone = new String(buff, 0, len, "UTF-8");
                System.out.print(respone);
            }
        } while(len > 0);
        
        inputStream.close();
        virtualMachine.detach();
    }
}