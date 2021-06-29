import java.util.ArrayList;
import java.util.Stack;

public class SimplifyDirectoryPath {

  public static void main(String[] args) {
    Stack<String> s = new Stack<>();

    String A =
      "/./../../giq/xns/zvk/../vkd/qhp/pyf/wie/atv/thv/./kqs/seq/fzw/cav/./../.././rjn/elx/gyn/lla/gkd/zig/qud/vyx/./eqd/ple/vst/loc/./../uak/wvz/vxe/ibc/../bns/psb/./kjo/bky/oks/./cjg/yyh/spf/abt";
    // String A = "/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..";

    if (A.indexOf('/') == -1) {
      System.out.println("no / present");
      System.exit(0);
    }

    String[] str = A.split("/");

    for (String x : str) {
      if (x.equals("..")) {
        if (!s.isEmpty()) s.pop();
      } else if (!(x.equals(".") || x.isEmpty())) {
        s.push(x);
      }
    }
    ArrayList<String> l = new ArrayList<>(s);

    System.out.println("/" + String.join("/", l));
  }
}
